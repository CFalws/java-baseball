package baseball.model;

import java.util.Arrays;

public enum GameCommand {
    RESTART(1),
    TERMINATION(2);

    private final int code;

    GameCommand(int code) {
        this.code = code;
    }

    public static GameCommand from(int code) {
        return Arrays.stream(values())
                .filter(gameCommand -> gameCommand.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean isRestart() {
        return this.equals(RESTART);
    }
}
