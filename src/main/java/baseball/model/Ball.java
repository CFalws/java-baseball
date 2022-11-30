package baseball.model;

public class Ball {
    private final BallNumber ballNumber;
    private final Position position;

    public Ball(BallNumber ballNumber, Position position) {
        this.ballNumber = ballNumber;
        this.position = position;
    }

    public boolean isBall(Ball other) {
        if (position == other.position) {
            return false;
        }
        return ballNumber == other.ballNumber;
    }

    public boolean isStrike(Ball other) {
        return position == other.position && ballNumber == other.ballNumber;
    }

    public BallNumber getBallNumber() {
        return ballNumber;
    }
}
