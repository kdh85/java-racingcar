package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CarsTest {

  @DisplayName("차량이름을 받아 특수문자 기준으로 이름을 만들어서 차량들을 생성한다.")
  @Test
  void createCars() {
    Cars cars = Cars.createCars("a,b,c");
    assertThat(cars).isEqualTo(Cars.createCars("a,b,c"));
  }

  @DisplayName("중복된 차량명을 제거하고 차들이 생성된다.")
  @Test
  void duplicateCars() {
    Cars cars = Cars.createCars("a,a,a,b");
    assertThat(cars).isEqualTo(Cars.createCars("a,b"));
  }
}