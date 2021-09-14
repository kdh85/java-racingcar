package domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class NameTest {

  @DisplayName("글자를 입력받아 이름 객체가 생성된다.")
  @ParameterizedTest
  @ValueSource(strings = {"test", "test1"})
  void nameCreate(String name) {
    Name newName = new Name(name);
    assertAll(
        () -> assertThat(newName).isEqualTo(new Name(name)),
        () -> assertThat(newName.name()).isEqualTo(name)
    );
  }

  @DisplayName("입력받는 이름의 길이가 5글자가 넘으면 에러가 반환횐다.")
  @ParameterizedTest
  @ValueSource(strings = {"test12", "가나다라마바"})
  @NullAndEmptySource
  void validationName(String name) {
    assertThatThrownBy(
        () -> new Name(name)
    ).isInstanceOf(IllegalArgumentException.class);
  }
}