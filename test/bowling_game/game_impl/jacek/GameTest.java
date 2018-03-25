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
    public void canCreateGame() {
        assertNotNull(sut);
    }
}