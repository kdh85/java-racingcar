package domain;

import dto.RacingResultDto;
import java.util.List;

public class Racing {

  private final int round;

  private final Cars cars;

  private int currentRound;

  public Racing(final Cars cars, final int round) {
    this.round = round;
    this.cars = cars;
  }

  public List<RacingResultDto> runningResult() {
    currentRound++;
    return cars.movingCars().racingResults();
  }

  public boolean isFinish() {
    return round != this.currentRound;
  }
}