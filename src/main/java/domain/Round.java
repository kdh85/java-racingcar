package domain;

import java.util.Objects;

public class Round {

  private static final int ROUND_VALUE = 1;
  private static final String MSG_ERROR_MIN_ROUND = "라운드값은 최소 1부터 가능합니다.";

  private final int round;

  private int currentRound;

  public Round(final int round) {
    validationRound(round);
    this.round = round;
  }

  private void validationRound(final int round) {
    if(round < ROUND_VALUE){
      throw new IllegalArgumentException(MSG_ERROR_MIN_ROUND);
    }
  }

  public int increaseRound(){
    return this.currentRound = currentRound + ROUND_VALUE;
  }

  public boolean isSameRound(){
    return round == this.currentRound;
  }

  public int maxRound(){
    return round;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Round round1 = (Round) o;
    return round == round1.round;
  }

  @Override
  public int hashCode() {
    return Objects.hash(round);
  }

  @Override
  public String toString() {
    return "Round{" +
        "round=" + round +
        '}';
  }
}
