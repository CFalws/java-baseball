package baseball.model;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class BallNumber {
    public static final int LOWER_BOUNDS = 1;
    public static final int UPPER_BOUNDS = 9;
    private static final Map<Integer, BallNumber> CACHE = new HashMap<>();
    private final int number;

    static {
        for (int number = LOWER_BOUNDS; number <= UPPER_BOUNDS; number++) {
            CACHE.put(number, new BallNumber(number));
        }
    }

    private BallNumber(int number) {
        validate(number);
        this.number = number;
    }

    private void validate(int ballNumber) {
        if (ballNumber < LOWER_BOUNDS || ballNumber > UPPER_BOUNDS) {
            throw new IllegalArgumentException();
        }
    }

    public static BallNumber valueOf(int number) {
        BallNumber ballNumber = CACHE.get(number);
        if (Objects.isNull(ballNumber)) {
            ballNumber = new BallNumber(number);
        }
        return ballNumber;
    }

    public int getNumber() {
        return number;
    }
}
