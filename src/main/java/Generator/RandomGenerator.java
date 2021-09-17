package Generator;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class RandomGenerator {

  private static final int MAX_NUMBER = 10;
  private static final int LESS_NUMBER = 1;
  private static final int START_INCLUSIVE = 0;

  private static final Random random = new Random();

  public static int createNumber() {
    return random.nextInt(MAX_NUMBER) * LESS_NUMBER;
  }

  public static List<Integer> createNumbers(final int count) {
    return IntStream.range(START_INCLUSIVE, count)
        .mapToObj(i -> random.nextInt(MAX_NUMBER) * LESS_NUMBER)
        .collect(Collectors.toList());
  }
}