package baseball.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BallsTest {

    Balls computer = new Balls(List.of(
            new Ball(BallNumber.valueOf(2), Position.valueOf(0)),
            new Ball(BallNumber.valueOf(4), Position.valueOf(1)),
            new Ball(BallNumber.valueOf(3), Position.valueOf(2))
    ));

    @ParameterizedTest
    @MethodSource("userBallsAndGameResult")
    void compare(Balls user, GameResult expected) {
        assertThat(computer.compare(user)).isEqualTo(expected);
    }

    static Stream<Arguments> userBallsAndGameResult() {
        return Stream.of(
                Arguments.of(
                        new Balls(List.of(new Ball(BallNumber.valueOf(2), Position.valueOf(0)),
                                new Ball(BallNumber.valueOf(4), Position.valueOf(1)),
                                new Ball(BallNumber.valueOf(3), Position.valueOf(2)))),
                        GameResult.of(0, 3)
                ),
                Arguments.of(
                        new Balls(List.of(new Ball(BallNumber.valueOf(2), Position.valueOf(0)),
                                new Ball(BallNumber.valueOf(3), Position.valueOf(1)),
                                new Ball(BallNumber.valueOf(7), Position.valueOf(2)))),
                        GameResult.of(1, 1)
                ),
                Arguments.of(
                        new Balls(List.of(new Ball(BallNumber.valueOf(1), Position.valueOf(0)),
                                new Ball(BallNumber.valueOf(7), Position.valueOf(1)),
                                new Ball(BallNumber.valueOf(5), Position.valueOf(2)))),
                        GameResult.of(0, 0)
                )
        );
    }
}