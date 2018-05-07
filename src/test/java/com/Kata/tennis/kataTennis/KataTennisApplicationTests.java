package com.Kata.tennis.kataTennis;

import com.Kata.tennis.kataTennis.domain.Game;
import com.Kata.tennis.kataTennis.domain.Player;
import com.Kata.tennis.kataTennis.domain.Result;
import com.Kata.tennis.kataTennis.domain.Set;
import java.util.stream.IntStream;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.hamcrest.CoreMatchers.*;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
public class KataTennisApplicationTests {

    Game game;

    @Before
    public void beforeGameTest() {
        Player player1 = new Player(1, "player1");
        Player player2 = new Player(2, "player2");
        Set set = new Set(0, 0);
        Result result = new Result(0, 0, "", "", 0, 0);
        game = new Game(player1, player2, set, result);
    }

    @Test
    public void ScoreMustBeginWithO() {
        assertThat(game.getResult().getPlayer1scoreSet(), is(0));
        assertThat(game.getResult().getPlayer2scoreSet(), is(0));
        assertThat(game.getResult().getPlayer1scoreGame(), is(""));
        assertThat(game.getResult().getPlayer2scoreGame(), is(""));
        assertThat(game.getResult().getCpt1(), is(0));
        assertThat(game.getResult().getCpt1(), is(0));
        assertNull(game.getResult().getPlayerWin());
    }

    @Test
    public void player2WonGame_2_6() {
        game.addPoint(game.getPlayer1().getRang());
        assertThat(game.getResult().getPlayer1scoreGame(), is("15"));

        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });

        assertThat(game.getResult().getPlayer2scoreSet(), is(1));

        IntStream.rangeClosed(1, 2).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });
        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        assertThat(game.getResult().getPlayer1scoreGame(), is("40"));
        assertThat(game.getResult().getPlayer2scoreGame(), is("30"));
        game.addPoint(game.getPlayer1().getRang());
        assertThat(game.getResult().getPlayer1scoreSet(), is(1));

        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        assertThat(game.getResult().getPlayer1scoreGame(), is("AD"));
        assertThat(game.getResult().getPlayer2scoreGame(), is(""));
        game.addPoint(game.getPlayer2().getRang());
        assertThat(game.getResult().getPlayer1scoreGame(), is("40"));
        assertThat(game.getResult().getPlayer2scoreGame(), is("40"));
        IntStream.rangeClosed(1, 2).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });

        IntStream.rangeClosed(1, 20).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });

        assertThat(game.getResult().getPlayer1scoreSet(), is(2));
        assertThat(game.getResult().getPlayer2scoreSet(), is(6));
        assertNotNull(game.getResult().getPlayerWin());

        assertThat(game.getResult().getPlayerWin(), equalTo(game.getPlayer2()));
    }

    @Test
    public void player1WonGame_6_6_tieBreak() {

        IntStream.rangeClosed(1, 20).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        IntStream.rangeClosed(1, 20).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });

        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });

        assertThat(game.getResult().getPlayer1scoreSet(), is(6));
        assertThat(game.getResult().getPlayer2scoreSet(), is(6));

        IntStream.rangeClosed(1, 6).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        
        assertThat(game.getResult().getCpt1(), is(6));
        game.addPoint(game.getPlayer2().getRang());
        assertThat(game.getResult().getCpt2(), is(1));
        game.addPoint(game.getPlayer1().getRang());
        
        assertThat(game.getResult().getCpt1(), is(7));
        assertNotNull(game.getResult().getPlayerWin());
        assertThat(game.getResult().getPlayerWin(), equalTo(game.getPlayer1()));
    }

    @Test
    public void player1WonGame_7_5() {

        IntStream.rangeClosed(1, 20).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        IntStream.rangeClosed(1, 20).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });

        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });

        IntStream.rangeClosed(1, 3).forEach((Integer) -> {
            game.addPoint(game.getPlayer2().getRang());
        });
        assertThat(game.getResult().getPlayer1scoreGame(), is("0"));
        assertThat(game.getResult().getPlayer2scoreGame(), is("40"));

        IntStream.rangeClosed(1, 4).forEach((Integer) -> {
            game.addPoint(game.getPlayer1().getRang());
        });
        assertThat(game.getResult().getPlayer1scoreGame(), is("AD"));
        assertThat(game.getResult().getPlayer2scoreGame(), is(""));

        game.addPoint(game.getPlayer1().getRang());

        assertThat(game.getResult().getPlayer1scoreSet(), is(7));
        assertThat(game.getResult().getPlayer2scoreSet(), is(5));

        assertNotNull(game.getResult().getPlayerWin());
        assertThat(game.getResult().getPlayerWin(), equalTo(game.getPlayer1()));
    }

}
