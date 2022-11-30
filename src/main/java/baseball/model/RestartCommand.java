package baseball.model;

import java.util.Arrays;

public enum RestartCommand {
    RESTART(1),
    END(0);

    private final int code;

    RestartCommand(int code) {
        this.code = code;
    }

    public static RestartCommand from(int code) {
        return Arrays.stream(values())
                .filter(restartCommand -> restartCommand.code == code)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public boolean isRestart() {
        return this == RESTART;
    }
}
