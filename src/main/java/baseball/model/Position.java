package baseball.model;

import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public class Position {
    private final int position;

    private static final Map<Integer, Position> CACHE = new HashMap<>();

    static {
        for (int position = 0; position < Balls.SIZE; position++) {
            CACHE.put(position, new Position(position));
        }
    }

    private Position(int position) {
        validate(position);
        this.position = position;
    }

    private static void validate(int position) {
        if (position < 0 || position >= Balls.SIZE) {
            throw new IllegalArgumentException();
        }
    }

    public static Position valueOf(int position) {
        validate(position);
        return CACHE.get(position);
    }

    public int getPosition() {
        return position;
    }
}
