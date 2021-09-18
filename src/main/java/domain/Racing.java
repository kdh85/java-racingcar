package domain;

import Generator.RandomGenerator;
import dto.RacingResultDto;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

  private static final String WINNER_SEPARATOR = ", ";

  private final int round;

  private final Cars cars;

  private int currentRound;

  public Racing(final Cars cars, final int round) {
    this.round = round;
    this.cars = cars;
  }

  public List<RacingResultDto> runningResult() {
    currentRound++;
    return cars.movingCars(RandomGenerator.createNumbers(round)).racingResults();
  }

  public boolean isFinish() {
    return round != this.currentRound;
  }

  public String winners() {
    return cars.findWinner()
        .stream()
        .map(Car::carName)
        .collect(Collectors.joining(WINNER_SEPARATOR));
  }
}