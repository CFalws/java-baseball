package baseball.model;

import java.util.HashMap;
import java.util.Map;

public class BallNumber {
    public static final int NUMBER_LOWER_BOUNDS = 1;
    public static final int NUMBER_UPPER_BOUNDS = 9;
    private static final Map<Integer, BallNumber> CACHE = new HashMap<>();
    private final int ballNumber;

    static {
        for (int number = NUMBER_LOWER_BOUNDS; number <= NUMBER_UPPER_BOUNDS; number++) {
            CACHE.put(number, new BallNumber(number));
        }
    }

    private BallNumber(int ballNumber) {
        validate(ballNumber);
        this.ballNumber = ballNumber;
    }

    private static void validate(int ballNumber) {
        if (ballNumber < NUMBER_LOWER_BOUNDS || ballNumber > NUMBER_UPPER_BOUNDS) {
            throw new IllegalArgumentException();
        }
    }

    public static BallNumber valueOf(int ballNumber) {
        validate(ballNumber);
        return CACHE.get(ballNumber);
    }

    public int getBallNumber() {
        return ballNumber;
    }
}
