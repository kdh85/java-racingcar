package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CarTest {

  private Car car;

  @BeforeEach
  void setUp() {
    car = new Car("abc");
  }

  @DisplayName("차량이름을 주입하면 기본이동거리 0인 차량이 생성된다.")
  @Test
  void createCar() {
    assertAll(
        () -> assertThat(car.carName()).isEqualTo("abc"),
        () -> assertThat(car.carDistance()).isEqualTo(0)
    );
  }

  @DisplayName("차량을 이동시키면 차의 이동거리가 1증가한다.")
  @ParameterizedTest
  @CsvSource(value = {"4,1", "3,0"})
  void moveTheCar(int number, int distance) {
    car.moveThaCar(number);
    assertThat(car.carDistance()).isEqualTo(distance);
  }

  @DisplayName("입력받는 숫자값이 0~9사이인지 검증한다.")
  @ParameterizedTest
  @ValueSource(ints = {-1, 10})
  void validationNumber(int number) {
    assertThatThrownBy(() -> car.moveThaCar(number))
        .isInstanceOf(IllegalArgumentException.class);
  }
}