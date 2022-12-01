package baseball.controller;

import baseball.model.BaseballGame;
import baseball.model.GameResult;
import baseball.view.InputView;
import baseball.view.OutputView;

import java.util.List;

public class BaseballGameController {
    private final InputView inputView = InputView.getInstance();
    private final OutputView outputView = OutputView.getInstance();
    private final BaseballGame baseballGame;

    public BaseballGameController(BaseballGame baseballGame) {
        this.baseballGame = baseballGame;
    }

    public void run() {
        initializeGame();
        while (baseballGame.isContinuing()) {
            playAGame();
            baseballGame.checkRegame(inputView.inputGameCommand());
        }
    }

    private void initializeGame() {
        outputView.printStartingMessage();
        baseballGame.init();
    }

    private void playAGame() {
        while (baseballGame.isContinuing()) {
            List<Integer> inputNumbers = inputView.inputNumbers();
            GameResult gameResult = baseballGame.compare(inputNumbers);
            outputView.printResult(gameResult);
        }
        outputView.printWinningMessage();
    }
}
