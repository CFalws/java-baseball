package baseball.view;

import baseball.model.RestartCommand;
import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

public class InputView {
    private static InputView inputView;

    public static InputView getInstance() {
        if (Objects.isNull(inputView)) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String inputNumbers() {
        System.out.print("숫자를 입력해주세요 : ");
        String numbers = Console.readLine();
        InputValidator.validateNumbers(numbers);
        return numbers;
    }

    public RestartCommand inputRestart() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String restart = Console.readLine();
        InputValidator.validateRestart(restart);
        return RestartCommand.from(Integer.parseInt(restart));
    }
}
