package bowling_game.game_impl.jacek;

import bowling_game.IGame;

// test comment
public class GameByJacek implements IGame {
    public static final int NUMBER_OF_PINS = 10;
    public static final int NUMBER_OF_FRAMES = 10;
    private int[] rolls = new int[21];
    private int currentRoll = 0;

    @Override
    public void roll(int pin) {
        rolls[currentRoll] = pin;
        currentRoll++;
    }

    @Override
    public int score() {
        int score = 0;

        for (int frame = 0, firstInFrame = 0; frame < NUMBER_OF_FRAMES; frame++) {
            if (isStrike(firstInFrame)) {
                score += NUMBER_OF_PINS + getStrikeBonus(firstInFrame);
                firstInFrame++;
            }
            else {
                if (isSpare(firstInFrame))
                    score += getSpareBonus(firstInFrame);
                score += frameScore(firstInFrame);
                firstInFrame+=2;
            }
        }

        return score;
    }

    private boolean isStrike(int firstInFrame) {
        return (rolls[firstInFrame] == NUMBER_OF_PINS);
    }

    private int getStrikeBonus(int firstInFrame) {
        return rolls[firstInFrame+1] + rolls[firstInFrame+2];
    }

    private int getSpareBonus(int firstInFrame) {
        return rolls[firstInFrame+2];
    }

    private int frameScore(int firstInFrame) {
        return rolls[firstInFrame] + rolls[firstInFrame+1];
    }

    private boolean isSpare(int firstInFrame) {
        return (frameScore(firstInFrame) == NUMBER_OF_PINS);
    }
}
