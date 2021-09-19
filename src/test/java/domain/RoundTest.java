package domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RoundTest {

  private Round round;

  @BeforeEach
  void setUp() {
    round = new Round(1);
  }

  @DisplayName("정상적으로 라운드값이 증가되는지 확인한다.")
  @Test
  void increaseRound() {
    assertThat(round.increaseRound()).isEqualTo(1);
  }

  @DisplayName("1 미만의 값으로 라운드가 생성되면 에러가 발생한다.")
  @Test
  void validationRound() {
    assertThatThrownBy(
        () -> new Round(0)
    ).isInstanceOf(IllegalArgumentException.class);
  }

  @DisplayName("현재의 라운드값이 총 라운드값과 같은지 비교한다.")
  @Test
  void isSameRound() {
    round.increaseRound();
    assertThat(round.isSameRound()).isTrue();
  }

  @DisplayName("입력받은 최대 라운드값을 반환한다.")
  @Test
  void maxRound() {
    assertThat(round.maxRound()).isEqualTo(1);
  }
}