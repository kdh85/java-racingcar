package view;

import dto.RacingResultDto;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class ResultView {

  private static final int START_INCLUSIVE = 0;
  private static final String RACING_PROGRESS_BAR = "-";
  private static final String RESULT_SEPARATOR = " : ";
  private static final String MSG_TITLE = "실행 결과";

  public static void printResult(final List<RacingResultDto> racingResult) {

    racingResult.stream()
        .map(ResultView::raceDisplay)
        .forEach(System.out::println);
    System.out.println();
  }

  private static String raceDisplay(final RacingResultDto racingResultDto) {
    return racingResultDto.getName() + RESULT_SEPARATOR + formatValue(
        racingResultDto.getDistance());
  }

  public static void printResultTitle() {
    System.out.println(MSG_TITLE);
  }

  private static String formatValue(final int distance) {
    return IntStream
        .range(START_INCLUSIVE, distance).mapToObj(i -> RACING_PROGRESS_BAR)
        .collect(Collectors.joining());
  }
}