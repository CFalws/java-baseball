package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.util.stream.Collectors.*;

public class ComputerBallsGenerator {
    public Balls generate() {
        List<Integer> uniqueNumbers = generateUniqueNumbers();
        return IntStream.rangeClosed(Position.LOWER_BOUNDS, Position.UPPER_BOUNDS)
                .mapToObj(position -> Ball.from(uniqueNumbers.get(position), position))
                .collect(collectingAndThen(toList(), Balls::new));
    }

    private List<Integer> generateUniqueNumbers() {
        Set<Integer> uniqueNumbers = new HashSet<>();
        while (hasEnough(uniqueNumbers)) {
            int number = Randoms.pickNumberInRange(BallNumber.LOWER_BOUNDS, BallNumber.UPPER_BOUNDS);
            uniqueNumbers.add(number);
        }
        return new ArrayList<Integer>(uniqueNumbers);
    }

    private static boolean hasEnough(Set<Integer> uniqueNumbers) {
        return uniqueNumbers.size() < Balls.SIZE;
    }
}
