package io.github.kji6252.game;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class GameTest {
    @Test
    void create() {
        Game game = new Game(1, 2, 3);
    }

    //파라미터 개수가 잘못된 상황
    @Test
    void badParamCnt() {
        Game game = new Game(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 2, 3, 4));
    }

    @Test
    void badParamNumRange() {
        Game game = new Game(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> game.guess(-1, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(10, 2, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(10, 10, 3));
        assertThrows(IllegalArgumentException.class, () -> game.guess(1, 2, 10));
    }

    //일치하지 않는 경우
    @Test
    void noMatch() {
        Game game = new Game(1, 2, 3);
        Score s = game.guess(4, 5, 6);

        assertEquals(0, s.balls());
        assertEquals(0, s.strikes());
    }

    @Test
    void S1_B0() {
        Game g = new Game(1, 2, 3);
        Score s = g.guess(1, 4, 5);
        assertScore(s, 0, 1);

        Score s2 = g.guess(4, 2, 5);
        assertScore(s2, 0, 1);
    }

    private void assertScore(Score s, int balls, int strikes) {
        assertEquals(s.balls(), balls);
        assertEquals(s.strikes(), strikes);
    }

    @Test
    void S2_B0() {
        Game g = new Game(1, 2, 3);
        //assertScore(g.guess(1,2,4), 0, 2);
        assertScore(g.guess(1, 4, 3), 0, 2);
        assertScore(g.guess(4, 2, 3), 0, 2);
    }

    @Test
    void S3_B0() {
        Game g = new Game(1, 2, 3);
        assertScore(g.guess(1, 2, 3), 0, 3);

    }

    @Test
    void S0_B1() {
        Game g = new Game(1, 2, 3);
        assertScore(g.guess(4, 1, 5), 1, 0);
        assertScore(g.guess(4, 5, 1), 1, 0);
        assertScore(g.guess(5, 4, 2), 1, 0);
        assertScore(g.guess(2, 4, 5), 1, 0);
        assertScore(g.guess(5, 3, 4), 1, 0);
    }

    @Test
    void S1_B1() {
        Game g = new Game(1,2,3);
        assertScore(g.guess(1,3,4), 1, 1);
        assertScore(g.guess(1,4,2), 1, 1);
    }

    @Test
    void S0_B2() {
        Game g = new Game(1,2,3);
        assertScore(g.guess(2,1,4),2,0);
    }
}
