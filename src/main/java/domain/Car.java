package domain;

import java.util.Objects;

public class Car {

  private static final int MOVE_LIMIT_NUMBER = 4;
  private static final int MIN_NUMBER = 0;
  private static final int MAX_NUMBER = 9;
  private static final String MSG_ERROR_LIMIT_NUMBER = "입력받는 난수값은 0부터 9까지입니다.";

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
    validationNumber(number);

    if (number >= MOVE_LIMIT_NUMBER) {
      moveDistance.move();
    }
  }

  private void validationNumber(final int number) {
    if (number < MIN_NUMBER || number > MAX_NUMBER) {
      throw new IllegalArgumentException(MSG_ERROR_LIMIT_NUMBER);
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
