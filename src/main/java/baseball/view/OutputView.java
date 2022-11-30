package baseball.view;

import baseball.model.GameResult;

import java.util.Objects;

public class OutputView {
    private static OutputView outputView;

    public static OutputView getInstance() {
        if (Objects.isNull(outputView)) {
            outputView = new OutputView();
        }
        return outputView;
    }

    public void printStart() {
        System.out.println("숫자 야구 게임을 시작합니다.");
    }

    public void printResult(GameResult gameResult) {
        System.out.println(gameResult.getResult());
        printRight(gameResult);
    }

    private void printRight(GameResult gameResult) {
        if (gameResult.isRight()) {
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
        }
    }
}
