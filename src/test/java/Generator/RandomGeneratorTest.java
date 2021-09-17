package Generator;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RandomGeneratorTest {

  @DisplayName("0~9사이로 랜덤한 숫자가 생성되는지 확인한다.")
  @Test
  void createNumber() {
    assertThat(RandomGenerator.createNumber()).isGreaterThan(-1).isLessThan(10);
  }

  @DisplayName("0~9사이로 랜덤한 숫자를 입력받은 수 만큼 생성되는지 확인한다.")
  @ParameterizedTest
  @ValueSource(ints = {1,3,5})
  void createNumbers(int count) {
    assertThat(RandomGenerator.createNumbers(count).size()).isEqualTo(count);
  }
}