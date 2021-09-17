package domain;

import Generator.RandomGenerator;
import dto.RacingResultDto;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class Cars {

  private static final String SPLIT_SEPARATOR = ",";

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

  public Cars movingCars() {
    cars.forEach(car -> car.moveThaCar(RandomGenerator.createNumber()));
    return this;
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
