package domain;

import dto.RacingResultDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class Cars {

  private static final String SPLIT_SEPARATOR = ",";
  private static final int SECOND_CAR_INDEX = 1;
  private static final int FIRST_CAR_INDEX = 0;

  private final List<Car> cars;

  public Cars(final List<Car> cars) {
    this.cars = Collections.unmodifiableList(cars);
  }

  public static Cars createCars(final String carNames) {
    return new Cars(splitCarNames(carNames)
        .stream()
        .map(Car::new)
        .collect(Collectors.toList()));
  }

  private static List<String> splitCarNames(final String carNames) {
    return Arrays.stream(carNames.split(SPLIT_SEPARATOR))
        .distinct()
        .collect(Collectors.toList());
  }

  public Cars movingCars(final List<Integer> numbers) {

    AtomicInteger count = new AtomicInteger();

    cars.forEach(car -> car.moveThaCar(numbers.get(count.getAndIncrement())));
    return this;
  }

  public List<Car> findWinner() {
    return cars.stream()
        .filter(this::isSameToMaxDistance)
        .collect(Collectors.toList());
  }

  private boolean isSameToMaxDistance(final Car car) {
    return car.carDistance() == findMaxDistance();
  }

  private int findMaxDistance() {
    int maxDistance = cars.get(FIRST_CAR_INDEX).carDistance();

    for (int i = SECOND_CAR_INDEX, carsSize = cars.size(); i < carsSize; i++) {
      maxDistance = cars.get(i).maxDistanceCar(maxDistance);
    }

    return maxDistance;
  }

  public List<RacingResultDto> racingResults() {
    return cars.stream()
        .map(car -> RacingResultDto.of(car.carDistance(), car.carName()))
        .collect(Collectors.toList());
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Cars cars1 = (Cars) o;
    return Objects.equals(cars, cars1.cars);
  }

  @Override
  public int hashCode() {
    return Objects.hash(cars);
  }

  @Override
  public String toString() {
    return "Cars{" +
        "cars=" + cars +
        '}';
  }
}
