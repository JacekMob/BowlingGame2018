package bowling_game.game_impl;

import org.junit.Before;
import org.junit.Test;
import bowling_game.IGame;
import bowling_game.game_impl.jacek.GameByJacek;

import static org.junit.Assert.*;

public class GameTest {

    private IGame sut;

    @Before
    public void setUp() throws Exception {
        sut = new GameByJacek();
    }

    @Test
    public void rolledAllZeroes_scoreIsZero() {
        rollMany(20, 0);

        assertEquals(0, sut.score());
    }

    @Test
    public void rolledAllOnes_scoreIs20() {
        rollMany(20, 1);

        assertEquals(20, sut.score());
    }

    @Test
    public void rolledSpare_nextRollIsBonus() {
        rollSpare();
        sut.roll(2);
        rollMany(17, 0);

        assertEquals(14, sut.score());
    }

    @Test
    public void rolledStrike_nextTwoRollsAreBonus() {
        sut.roll(10);
        sut.roll(2);
        sut.roll(3);
        rollMany(17, 0);

        assertEquals(20, sut.score());
    }

    @Test
    public void perfectGame_scoreIs300() {
        rollMany(12, 10);

        assertEquals(300, sut.score());
    }

    @Test
    public void rolledAll5_scoreIs150() {
        rollMany(21, 5);

        assertEquals(150, sut.score());
    }

    private void rollSpare() {
        sut.roll(5);
        sut.roll(5);
    }

    private void rollMany(int rolls, int pins) {
        for (int i = 0; i < rolls; i++) {
            sut.roll(pins);
        }
    }
}