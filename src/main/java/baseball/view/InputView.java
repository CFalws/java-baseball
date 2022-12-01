package baseball.view;

import baseball.model.GameCommand;
import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class InputView {
    public static final String INPUT_NUMBERS_MESSAGE = "숫자를 입력해주세요 : ";
    public static final String INPUT_GAME_COMMAND_MESSAGE = "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.";
    private static InputView inputView;

    public static InputView getInstance() {
        if (Objects.isNull(inputView)) {
            inputView = new InputView();
        }
        return inputView;
    }

    public List<Integer> inputNumbers() {
        System.out.print(INPUT_NUMBERS_MESSAGE);
        String numbers = Console.readLine();
        InputValidator.validateNumbers(numbers);
        return toList(numbers);
    }

    private static List<Integer> toList(String numbers) {
        return IntStream.range(0, numbers.length())
                .mapToObj(i -> Integer.parseInt(numbers.substring(i, i + 1)))
                .collect(Collectors.toList());
    }

    public GameCommand inputGameCommand() {
        System.out.println(INPUT_GAME_COMMAND_MESSAGE);
        String commandCode = Console.readLine();
        InputValidator.validateCommandCode(commandCode);
        return GameCommand.from(Integer.parseInt(commandCode));
    }
}
