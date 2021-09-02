package com.controller;

import com.domain.Game;
import com.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Random;
import java.util.UUID;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;

    @RequestMapping(value="/game", method= RequestMethod.POST)
    public @ResponseBody Game createGame() {

        // get all target word
        String[] wordList = gameService.loadWordList();

        Game newGame = new Game(UUID.randomUUID().toString(), wordList[(new Random(System.nanoTime()).nextInt(wordList.length))]);
        gameService.saveNewGame(newGame);
        return newGame;
    }

    /**
     * Updates a game resource when the player makes a guess.
      */
    @RequestMapping(value = "/game/{id}", method=RequestMethod.PUT)
    public @ResponseBody Game makeGuess(@PathVariable String id,
                                        @RequestParam(value="letter") String letter) {

        Game game = gameService.getGame(id);

        if (game.getGameState() == 0) {
            // In case the player type more than one character, take the first one
            String singleLetter = String.valueOf(letter.charAt(0));

            gameService.makeGuess(game, singleLetter);
        }
        return game;
    }

}
