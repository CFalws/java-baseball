package baseball.model;

import java.util.Arrays;

public enum GameResult {
    STRIKE_3_BALL_0(3, 0, "3스트라이크"),
    STRIKE_1_BALL_2(1, 2, "2볼 1스트라이크"),
    STRIKE_0_BALL_3(0, 3, "3볼"),
    STRIKE_2_BALL_0(2, 0, "2스트라이크"),
    STRIKE_1_BALL_1(1, 1, "1볼 1스트라이크"),
    STRIKE_0_BALL_2(0, 2, "2볼"),
    STRIKE_1_BALL_0(1, 0, "1스트라이크"),
    STRIKE_0_BALL_1(0, 1, "1볼"),
    NOTHING(0, 0, "낫싱");

    private final int strikeCount;
    private final int ballCount;
    private final String output;

    GameResult(int strikeCount, int ballCount, String output) {
        this.strikeCount = strikeCount;
        this.ballCount = ballCount;
        this.output = output;
    }

    public static GameResult of(int ballCount, int strikeCount) {
        return Arrays.stream(values())
                .filter(gameResult -> gameResult.matches(ballCount, strikeCount))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    private boolean matches(int ballCount, int strikeCount) {
        return this.strikeCount == strikeCount && this.ballCount == ballCount;
    }

    public boolean isUserWin() {
        return this.equals(STRIKE_3_BALL_0);
    }

    public String getOutput() {
        return output;
    }
}
