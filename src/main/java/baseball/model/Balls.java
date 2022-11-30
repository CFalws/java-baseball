package baseball.model;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Balls {
    public static final int SIZE = 3;

    private final List<Ball> balls;

    public static Balls from(List<Integer> numbers) {
        List<Ball> ballList = IntStream.range(0, numbers.size())
                .mapToObj(i -> Ball.from(numbers.get(i), i))
                .collect(Collectors.toList());
        return new Balls(ballList);
    }

    public Balls(List<Ball> balls) {
        validate(balls);
        this.balls = balls;
    }

    private void validate(List<Ball> balls) {
        validateSize(balls);
        validateDuplication(balls);
    }

    private void validateSize(List<Ball> balls) {
        if (balls.size() != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateDuplication(List<Ball> balls) {
        long uniqueBallsCount = balls.stream()
                .map(Ball::getNumber)
                .distinct()
                .count();

        if (uniqueBallsCount != SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public GameResult compare(Balls opponent) {
        int ballCount = countFiltered(opponent, this::ballPredicate);
        int strikeCount = countFiltered(opponent, this::strikePredicate);
        return GameResult.of(ballCount, strikeCount);
    }

    private int countFiltered(Balls opponent, Predicate<Ball> predicate) {
        return (int) opponent.balls.stream()
                .filter(predicate)
                .count();
    }

    private boolean ballPredicate(Ball otherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.isBall(otherBall));
    }

    private boolean strikePredicate(Ball otherBall) {
        return balls.stream()
                .anyMatch(ball -> ball.isStrike(otherBall));
    }
}
