package baseball.view;

public class InputValidator {
    public static void validateNumbers(String numbers) {
        try {
            Integer.parseInt(numbers);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    public static void validateCommandCode(String restart) {
        try {
            Integer.parseInt(restart);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }
}
