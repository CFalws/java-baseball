package baseball.model;

public class Ball {
    private final BallNumber number;
    private final Position position;

    public Ball(BallNumber number, Position position) {
        this.number = number;
        this.position = position;
    }

    public static Ball from(int number, int position) {
        return new Ball(BallNumber.valueOf(number), Position.valueOf(position));
    }

    public boolean isBall(Ball other) {
        return !position.equals(other.position) && number.equals(other.number);
    }

    public boolean isStrike(Ball other) {
        return position.equals(other.position) && number.equals(other.number);
    }

    public BallNumber getNumber() {
        return number;
    }
}
