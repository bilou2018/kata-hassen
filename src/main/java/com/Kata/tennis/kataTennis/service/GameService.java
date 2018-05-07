/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Kata.tennis.kataTennis.service;

import com.Kata.tennis.kataTennis.conf.IllegalBusinessLogiqueException;
import com.Kata.tennis.kataTennis.domain.Game;
import com.Kata.tennis.kataTennis.domain.Player;
import com.Kata.tennis.kataTennis.domain.Result;
import com.Kata.tennis.kataTennis.domain.Set;
import org.springframework.stereotype.Service;

/**
 *
 * @author DELL
 */
@Service
public class GameService {

    Game game;

    public Game addMatch(String player1, String player2) {
        Player p1 = new Player(1, player1);
        Player p2 = new Player(2, player2);
        Set set = new Set(0, 0);
        Result result = new Result(0, 0, "", "", 0, 0);
        game = new Game(p1, p2, set, result);
        return game;
    }

    public void addPoint(int rang) {
        game.addPoint(rang);
    }
}
