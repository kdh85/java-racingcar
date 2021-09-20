import domain.Cars;
import domain.Racing;
import view.InsertView;
import view.ResultView;

public class RacingMain {

  public static void main(String[] args) {

    Racing racing = new Racing(Cars.createCars(InsertView.names()), InsertView.round());

    ResultView.printResultTitle();

    while (racing.isContinue()) {
      ResultView.printResult(racing.runningResult());
    }
    ResultView.printWinner(racing.winners());
  }
}