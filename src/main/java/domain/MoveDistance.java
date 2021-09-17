package domain;

import java.util.Objects;

public class MoveDistance {

  private int distance;

  public MoveDistance() {
    distance = 0;
  }

  public void move() {
    distance += 1;
  }

  public int distance(){
    return distance;
  }

  public boolean isMaxDistance(final MoveDistance target) {
    return target.distance > this.distance;
  }

  public boolean isSameDistance(final MoveDistance target) {
    return target.distance == this.distance;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final MoveDistance that = (MoveDistance) o;
    return distance == that.distance;
  }

  @Override
  public int hashCode() {
    return Objects.hash(distance);
  }

  @Override
  public String toString() {
    return "MoveDistance{" +
        "distance=" + distance +
        '}';
  }
}
