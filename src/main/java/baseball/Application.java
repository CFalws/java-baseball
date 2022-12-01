package baseball;

import baseball.controller.BaseballGameController;
import baseball.model.BaseballGame;
import baseball.model.ComputerBallsGenerator;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BaseballGameController baseballGameController = new BaseballGameController(baseballGame());
        baseballGameController.run();
    }

    private static BaseballGame baseballGame() {
        return new BaseballGame(computerBallsGenerator());
    }

    private static ComputerBallsGenerator computerBallsGenerator() {
        return new ComputerBallsGenerator();
    }
}
