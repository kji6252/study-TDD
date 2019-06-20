package io.github.kji6252.game;

public class Game {
    private int[] nums;

    public Game(int... nums) {
        this.nums = nums;
    }

    public Score guess(int... answer) {
        checkBalidAnswer(answer);
        return new Score(balls(answer), strikes(answer));
    }

    private void checkBalidAnswer(int[] answer) {
        if(answer.length != 3)
            throw new IllegalArgumentException();

        for (int i = 0; i < answer.length; i++) {
            if(answer[i] < 0 || answer[i] > 9)
                throw new IllegalArgumentException();
        }
    }

    private int balls(int[] answer) {
        int balls = 0;
        if(answer[1] == nums[0] || answer[2] == nums[0])
            balls++;
        if(answer[0] == nums[1] || answer[2] == nums[1])
            balls++;
        if(answer[0] == nums[2] || answer[1] == nums[2])
            balls++;
        return balls;
    }

    private int strikes(int[] answer) {
        int strikes = 0;
        for (int i = 0; i < answer.length; i++) {
            if(answer[i] == nums[i])
                strikes++;
        }
        return strikes;
    }
}
