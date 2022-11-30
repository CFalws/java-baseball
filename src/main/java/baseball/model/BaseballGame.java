package baseball.model;

import java.util.List;

public class BaseballGame {
    private final ComputerBallsGenerator computerBallsGenerator;
    private GameStatus gameStatus;
    private Balls computerBalls;

    public BaseballGame(ComputerBallsGenerator computerBallsGenerator) {
        this.computerBallsGenerator = computerBallsGenerator;
    }

    public void init() {
        gameStatus = GameStatus.CONTINUING;
        computerBalls = computerBallsGenerator.generate();
    }

    public boolean isContinuing() {
        return gameStatus.isContinuing();
    }

    public GameResult compare(List<Integer> inputNumbers) {
        Balls userBalls = Balls.from(inputNumbers);
        GameResult result = computerBalls.compare(userBalls);
        checkUserWin(result);
        return result;
    }

    private void checkUserWin(GameResult result) {
        if (result.isUserWin()) {
            gameStatus = GameStatus.STOP;
        }
    }

    public void checkRegame(GameCommand gameCommand) {
        if (gameCommand.isRestart()) {
            gameStatus = GameStatus.CONTINUING;
            computerBalls = computerBallsGenerator.generate();
        }
    }
}
