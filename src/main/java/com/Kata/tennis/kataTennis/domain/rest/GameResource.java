
package com.Kata.tennis.kataTennis.domain.rest;

import com.Kata.tennis.kataTennis.conf.IllegalBusinessLogiqueException;
import com.Kata.tennis.kataTennis.domain.Game;
import com.Kata.tennis.kataTennis.domain.Result;
import com.Kata.tennis.kataTennis.service.GameService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author DELL
 */
@RestController
@RequestMapping("/api/tennis")
public class GameResource {

    private final Logger log = LoggerFactory.getLogger(GameResource.class);
    Game game;
    @Autowired
    GameService gameService;

    @PostMapping("/addMatch")
    public ResponseEntity<Void> addMatch(@RequestParam(name = "player1", required = true) String player1, @RequestParam(name = "player2", required = true) String player2) {
        log.info("Request to add Match between: {} and {}", player1, player2);
        game= gameService.addMatch(player1, player2);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/addPoint")
    public ResponseEntity<Result> addPoint(@RequestParam(name = "PlayerRang", required = true) int rang) {
        log.info("Request to add point and get game result : {}",rang);
        if (rang!=1 && rang !=2)
            throw new IllegalBusinessLogiqueException("Rang must be equal to 1 or 2");
        if (game != null) {
            gameService.addPoint(rang);
        }else
             throw new IllegalBusinessLogiqueException("Expire session or No existing match");
        return ResponseEntity.ok().body(game.getResult());
    }
}
