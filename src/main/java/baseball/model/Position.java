package baseball.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Position {
    public static final int LOWER_BOUNDS = 0;
    public static final int UPPER_BOUNDS = 2;
    private final int position;

    private static final Map<Integer, Position> CACHE = new HashMap<>();

    static {
        for (int position = LOWER_BOUNDS; position <= UPPER_BOUNDS; position++) {
            CACHE.put(position, new Position(position));
        }
    }

    private Position(int position) {
        validate(position);
        this.position = position;
    }

    private void validate(int position) {
        if (position < LOWER_BOUNDS || position > UPPER_BOUNDS) {
            throw new IllegalArgumentException();
        }
    }

    public static Position valueOf(int number) {
        Position position = CACHE.get(number);
        if (Objects.isNull(position)) {
            position = new Position(number);
        }
        return position;
    }

    public int getPosition() {
        return position;
    }
}
