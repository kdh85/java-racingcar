package view;

import java.util.Scanner;

public class InsertView {

  private static final String MSG_INSERT_CAR_NAMES = "경주할 자동차 이름을 입력하세요(이름은 쉼표(,)를 기준으로 구분).";
  private static final String MSG_INSERT_ROUND = "시도할 회수는 몇회인가요?";

  private static Scanner scanner = new Scanner(System.in);

  public static int round() {
    System.out.println(MSG_INSERT_ROUND);
    return scanner.nextInt();
  }

  public static String names() {
    System.out.println(MSG_INSERT_CAR_NAMES);
    return scanner.nextLine();
  }
}
