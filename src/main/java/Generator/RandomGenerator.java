package Generator;

import java.util.Random;

public class RandomGenerator {

  private static final int MAX_NUMBER = 10;
  private static final int LESS_NUMBER = 1;

  private static final Random random = new Random();

  public static int createNumber() {
    return random.nextInt(MAX_NUMBER) * LESS_NUMBER;
  }
}