package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;
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

  @DisplayName("입력하는 변수값이 4가 넘는 경우 해당 차량이 이동거리가 증가하는지 확인한다.")
  @Test
  void movingCars() {
    Cars cars = Cars.createCars("a,b,c");
    cars.movingCars(Arrays.asList(5, 1, 2));

    assertAll(
        () -> assertThat(cars.racingResults().get(0).getDistance()).isEqualTo(1),
        () -> assertThat(cars.racingResults().get(1).getDistance()).isEqualTo(0),
        () -> assertThat(cars.racingResults().get(2).getDistance()).isEqualTo(0)
    );
  }

  @DisplayName("이동거리 비교를 통해서 최대 이동한 거리를 찾는다.")
  @Test
  void maxDistance()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Cars cars = Cars.createCars("a,b,c");
    cars.movingCars(Arrays.asList(4, 1, 5));
    cars.movingCars(Arrays.asList(2, 1, 2));
    cars.movingCars(Arrays.asList(3, 1, 5));

    Method findMaxDistance = cars.getClass()
        .getDeclaredMethod("findMaxDistance");
    findMaxDistance.setAccessible(true);

    assertThat(findMaxDistance.invoke(cars)).isEqualTo(2);
  }

  @DisplayName("같은 거리인지 비교한다.")
  @Test
  void sameDistance()
      throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
    Cars cars = Cars.createCars("a");

    Method isSameToMaxDistance = cars.getClass()
        .getDeclaredMethod("isSameToMaxDistance", Car.class);
    isSameToMaxDistance.setAccessible(true);
    assertThat(isSameToMaxDistance.invoke(cars, new Car("b"))).isEqualTo(true);
  }

  @DisplayName("승리자를 확인한다.")
  @Test
  void findWinner() {
    Cars cars = Cars.createCars("a,b,c");
    cars.movingCars(Arrays.asList(4, 1, 5));

    List<Car> winner = cars.findWinner();
    assertAll(
        () -> assertThat(winner.get(0).carName()).isEqualTo("a"),
        () -> assertThat(winner.get(1).carName()).isEqualTo("c")
    );
  }
}