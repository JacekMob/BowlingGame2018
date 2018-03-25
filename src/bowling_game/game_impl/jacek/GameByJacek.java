package bowling_game.game_impl.jacek;

public class GameByJacek {
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    public void roll(int pin) {
        rolls[currentRoll] = pin;
        currentRoll++;
    }

    public int score() {
        int score = 0;
        for (int frame = 0, firstInFrame = 0; frame < 10; frame++) {
            if (isSpare(firstInFrame)) {
                score += getSpareBonus(firstInFrame);
            }

            score += frameScore(firstInFrame);
            firstInFrame+=2;
        }
        return score;
    }

    private int getSpareBonus(int firstInFrame) {
        return rolls[firstInFrame+2];
    }

    private int frameScore(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1];
    }

    private boolean isSpare(int firstInFrame) {
        return (frameScore(firstInFrame) == 10);
    }
}
