package baseball.view;

import baseball.model.GameResult;

import java.util.Objects;

public class OutputView {
    public static final String STARTING_MESSAGE = "숫자 야구 게임을 시작합니다.";
    public static final String WINNING_MESSAGE = "3개의 숫자를 모두 맞히셨습니다! 게임 종료";
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (Objects.isNull(outputView)) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printStartingMessage() {
        System.out.println(STARTING_MESSAGE);
    }

    public void printResult(GameResult gameResult) {
        System.out.println(gameResult.getOutput());
    }

    public void printWinningMessage() {
        System.out.println(WINNING_MESSAGE);
    }
}
