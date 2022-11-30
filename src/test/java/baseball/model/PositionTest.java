package baseball.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class PositionTest {

    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2})
    void valueOf(int position) {
        assertThat(Position.valueOf(position).getPosition()).isEqualTo(position);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 3})
    void valueOf_예외_던진다(int position) {
        assertThatThrownBy(() -> Position.valueOf(position))
                .isInstanceOf(IllegalArgumentException.class);
    }
}