package baseball.model;

public enum GameStatus {
    CONTINUING,
    STOP;

    public boolean isContinuing() {
        return this.equals(CONTINUING);
    }
}
