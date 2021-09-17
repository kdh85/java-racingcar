package domain;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MoveDistanceTest {

  private MoveDistance moveDistance;

  @BeforeEach
  void setUp() {
    moveDistance = new MoveDistance();
  }

  @DisplayName("기본 거리 0으로 객체 생성이 된다.")
  @Test
  void defaultDistance() {
    assertThat(moveDistance.distance()).isEqualTo(0);
  }

  @DisplayName("이동을 수행하면 거리1이 증가한다.")
  @Test
  void move() {
    moveDistance.move();
    assertThat(moveDistance.distance()).isEqualTo(1);
  }

  @DisplayName("이동거리 최대값을 구한다.")
  @Test
  void isMaxDistance() {
    MoveDistance target = new MoveDistance();
    target.move();
    assertThat(moveDistance.isMaxDistance(target)).isTrue();
  }

  @DisplayName("이동거리가 같은지 확인한다.")
  @Test
  void isSameDistance() {
    MoveDistance target = new MoveDistance();
    assertThat(moveDistance.isSameDistance(target)).isTrue();
  }
}