package bowling_game.game_impl.jacek;

public class GameByJacek {
    private int score = 0;

    public void roll(int i) {
        score += i;
    }

    public int score() {
        return score;
    }
}
