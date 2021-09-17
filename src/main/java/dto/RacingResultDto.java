package dto;

import java.util.Objects;

public class RacingResultDto {

  private final int distance;

  private final String name;

  private RacingResultDto(final int distance, final String name) {
    this.distance = distance;
    this.name = name;
  }

  public static RacingResultDto of(final int distance, final String name){
    return new RacingResultDto(distance, name);
  }

  public int getDistance() {
    return distance;
  }

  public String getName() {
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
    final RacingResultDto that = (RacingResultDto) o;
    return distance == that.distance && Objects.equals(name, that.name);
  }

  @Override
  public int hashCode() {
    return Objects.hash(distance, name);
  }

  @Override
  public String toString() {
    return "RacingResultDto{" +
        "distance=" + distance +
        ", name='" + name + '\'' +
        '}';
  }
}
