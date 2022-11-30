package baseball.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ComputerBallsGenerator {
    public Balls generate() {
        List<Ball> balls = new ArrayList<>();
        List<Integer> uniqueNumbers = generateUniqueNumbers();
        for (int pos = 0; pos < Balls.SIZE; pos++) {
            BallNumber ballNumber = BallNumber.valueOf(uniqueNumbers.get(pos));
            Position position = Position.valueOf(pos);
            balls.add(new Ball(ballNumber, position));
        }
        return new Balls(balls);
    }

    private List<Integer> generateUniqueNumbers() {
        Set<Integer> numbers = new HashSet<>();
        while (numbers.size() < Balls.SIZE) {
            numbers.add(Randoms.pickNumberInRange(BallNumber.NUMBER_LOWER_BOUNDS, BallNumber.NUMBER_UPPER_BOUNDS));
        }
        return new ArrayList<Integer>(numbers);
    }
}
