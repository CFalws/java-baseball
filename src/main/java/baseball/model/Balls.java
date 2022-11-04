package baseball.model;

import java.util.List;
import java.util.Objects;

public class Balls {
    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        this.balls = balls;
    }

    public boolean hasStrike(Ball other) {
        for (Ball ball : balls) {
            if (ball.isStrike(other)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBall(Ball other) {
        for (Ball ball : balls) {
            if (other.isBall(ball)) {
                return true;
            }
        }
        return false;
    }
}
