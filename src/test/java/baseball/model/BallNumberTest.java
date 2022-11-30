package baseball.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BallNumberTest {
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 9})
    void valueOf(int ballNumber) {
        assertThat(BallNumber.valueOf(ballNumber).getNumber()).isEqualTo(ballNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 10})
    void valueOf_예외_던진다(int ballNumber) {
        assertThatThrownBy(() -> BallNumber.valueOf(ballNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}