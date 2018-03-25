package bowling_game.game_impl.jacek;

import org.junit.Before;
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
        for (int i = 0; i < 20; i++) {
            sut.roll(0);
        }

        assertEquals(0, sut.score());
    }
}