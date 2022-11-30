package baseball.model;

import java.util.Arrays;

public enum GameResult {
    STRIKE_3_BALL_0(3, 0, "3스트라이크"),
    STRIKE_2_BALL_1(2, 1, "1볼 2스트라이크"),
    STRIKE_1_BALL_2(1, 2, "2볼 1스트라이크"),
    STRIKE_0_BALL_3(0, 3, "3볼"),
    STRIKE_2_BALL_0(2, 0, "2스트라이크"),
    STRIKE_1_BALL_1(1, 1, "1볼 1스트라이크"),
    STRIKE_0_BALL_2(0, 2, "2볼"),
    STRIKE_1_BALL_0(1, 0, "1스트라이크"),
    STRIKE_0_BALL_1(0, 1, "1볼"),
    OUT(0, 0, "낫싱");

    private final int strike;
    private final int ball;
    private final String result;

    GameResult(int strike, int ball, String result) {
        this.strike = strike;
        this.ball = ball;
        this.result = result;
    }

    public static GameResult of(int ballCount, int strikeCount) {
        return Arrays.stream(values())
                .filter(gameResult -> gameResult.strike == strikeCount && gameResult.ball == ballCount)
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException());
    }

    public String getResult() {
        return result;
    }

    public boolean isRight() {
        return this == STRIKE_3_BALL_0;
    }
}
