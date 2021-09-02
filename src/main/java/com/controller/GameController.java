package com.controller;

import com.domain.Game;
import com.domain.GameState;
import com.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value="/game")
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value="/", method= RequestMethod.POST)
    public @ResponseBody Game createGame() {
        return gameService.createNewGame();
    }

    /**
     * Updates a game resource when the player makes a guess.
      */
    @RequestMapping(value = "/{id}", method=RequestMethod.PUT)
    public @ResponseBody Game makeGuess(@PathVariable String id,
                                        @RequestParam(value="letter") String letter) {

        Game game = gameService.select(id);

        if (game.getGameState() == GameState.ACTIVE) {
            // In case the player type more than one character, take the first one
            String singleLetter = String.valueOf(letter.charAt(0));

            gameService.update(game, singleLetter);
        }
        return game;
    }

}
