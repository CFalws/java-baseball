package baseball.controller;

import baseball.model.Balls;
import baseball.model.ComputerBallsGenerator;
import baseball.model.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

public class BaseballGameController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final ComputerBallsGenerator computerBallsGenerator;

    public BaseballGameController(ComputerBallsGenerator computerBallsGenerator) {
        this.computerBallsGenerator = computerBallsGenerator;
    }

    public void run() {
        outputView.printStart();
        do {
            playAGame();
        } while (inputView.inputRestart().isRestart());
    }

    private void playAGame() {
        GameResult gameResult = null;
        Balls computerBalls = computerBallsGenerator.generate();
        do {
            String inputNumbers = inputView.inputNumbers();
            Balls user = new Balls(inputNumbers);
            gameResult = computerBalls.compare(user);
            outputView.printResult(gameResult);
        } while (!gameResult.isRight());
    }
}
