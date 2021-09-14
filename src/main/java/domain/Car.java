package domain;

import java.util.Objects;

public class Car {

  private static final int MOVE_LIMIT_NUMBER = 4;
  private final Name carName;

  private final MoveDistance moveDistance;

  public Car(final String carName) {
    this.carName = new Name(carName);
    this.moveDistance = new MoveDistance();
  }

  public int carDistance() {
    return moveDistance.distance();
  }

  public String carName() {
    return carName.name();
  }

  public void moveThaCar(final int number) {
    if(number >= MOVE_LIMIT_NUMBER){
      moveDistance.move();
    }
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Car car = (Car) o;
    return Objects.equals(carName, car.carName) && Objects.equals(moveDistance,
        car.moveDistance);
  }

  @Override
  public int hashCode() {
    return Objects.hash(carName, moveDistance);
  }

  @Override
  public String toString() {
    return "Car{" +
        "carName=" + carName +
        ", moveDistance=" + moveDistance +
        '}';
  }
}
