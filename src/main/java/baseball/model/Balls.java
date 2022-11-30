package baseball.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    public static final int SIZE = 3;

    private final List<Ball> balls;

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    public Balls(String ballsString) {
        balls = IntStream.range(0, ballsString.length())
                .mapToObj(i -> new Ball(BallNumber.valueOf(Integer.parseInt(ballsString.substring(i, i + 1))),
                        Position.valueOf(i)))
                .collect(Collectors.toList());
        validate(balls);
    }

    private void validate(List<Ball> balls) {
        long count = balls.stream()
                .map(Ball::getBallNumber)
                .distinct()
                .count();
        if (count != SIZE || balls.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public GameResult compare(Balls other) {
        int ballCount = count(other, this::checkBall);
        int strikeCount = count(other, this::checkStrike);
        return GameResult.of(ballCount, strikeCount);
    }

    private int count(Balls other, Predicate<Ball> checker) {
        return (int) other.balls.stream()
                .filter(otherBall -> checker.test(otherBall))
                .count();
    }

    private boolean checkBall(Ball otherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.isBall(otherBall));
    }

    private boolean checkStrike(Ball otherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.isStrike(otherBall));
    }

}
