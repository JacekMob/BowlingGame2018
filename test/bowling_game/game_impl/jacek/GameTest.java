package bowling_game.game_impl.jacek;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class GameTest {

    private GameByJacek sut;

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