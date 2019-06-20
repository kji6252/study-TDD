package io.github.kji6252.game;

public class Score {
    private int balls;
    private int strikes;

    public Score(int balls, int strikes) {
        this.balls = balls;
        this.strikes = strikes;
    }

    public int balls() {
        return balls;
    }

    public int strikes() {
        return strikes;
    }
}
