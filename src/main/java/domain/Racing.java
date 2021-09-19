package domain;

import Generator.RandomGenerator;
import dto.RacingResultDto;
import java.util.List;
import java.util.stream.Collectors;

public class Racing {

  private static final String WINNER_SEPARATOR = ", ";

  private final Cars cars;

  private final Round round;

  public Racing(final Cars cars, final int round) {
    this.round = new Round(round);
    this.cars = cars;
  }

  public List<RacingResultDto> runningResult() {
    round.increaseRound();
    return cars.movingCars(RandomGenerator.createNumbers(round.maxRound())).racingResults();
  }

  public boolean isFinish() {
    return !round.isSameRound();
  }

  public String winners() {
    return cars.findWinner()
        .stream()
        .map(Car::carName)
        .collect(Collectors.joining(WINNER_SEPARATOR));
  }
}