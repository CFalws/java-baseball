package baseball.view;

import baseball.model.Balls;

public class InputValidator {
    public static void validateNumbers(String numbers) {
        if (numbers.length() != Balls.SIZE) {
            throw new IllegalArgumentException();
        }
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateRestart(String restart) {
        try {
            Integer.parseInt(restart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
