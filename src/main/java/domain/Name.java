package domain;

import java.util.Objects;

public class Name {

  private static final int NAME_MAX_LENGTH = 5;
  private static final String MSG_ERROR_CREATE_NAME = "이름은 최대 5글자까지 가능합니다.";
  private final String name;

  public Name(final String name) {
    validationName(name);
    this.name = name;
  }

  private void validationName(final String name) {
    if (name == null || name.isEmpty()) {
      throw new IllegalArgumentException(MSG_ERROR_CREATE_NAME);
    }

    if (name.length() > NAME_MAX_LENGTH) {
      throw new IllegalArgumentException(MSG_ERROR_CREATE_NAME);
    }
  }

  public String name() {
    return name;
  }

  @Override
  public boolean equals(final Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    final Name name1 = (Name) o;
    return Objects.equals(name, name1.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(name);
  }

  @Override
  public String toString() {
    return "Name{" +
        "name='" + name + '\'' +
        '}';
  }
}
