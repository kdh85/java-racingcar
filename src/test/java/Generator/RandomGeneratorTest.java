package Generator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomGeneratorTest {

  @DisplayName("0~9사이로 랜덤한 숫자가 생성되는지 확인한다.")
  @Test
  void createNumber() {
    assertThat(RandomGenerator.createNumber()).isGreaterThan(-1).isLessThan(10);
  }
}