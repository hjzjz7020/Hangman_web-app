package com.controller;

import com.domain.Account;
import com.domain.Game;
import com.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;
import java.util.UUID;

@Controller
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private HttpServletRequest request;

    /**
     * creat a new Hangman game.
     * @return forward to game page.
     */
//    @RequestMapping(value="/newGame")
//    public String newGame() {
//
//        // TODO: using an fake account
//        Account player = new Account();
//        player.setId(10);
//        player.setPlayer_name("fake_player");
//        player.setPassword("fake_password");
//        player.setManagement_status(true);
//
//        // get all target word
//        String[] wordList = gameService.loadWordList();
//        // initialize a new hangman game.
//        Game newGame = new Game(wordList[(new Random(System.nanoTime()).nextInt(wordList.length))], player.getId());
//
//        gameService.saveNewGame(newGame);
//        return "newGame";
//    }

    @RequestMapping(value="/game", method= RequestMethod.POST)
    public @ResponseBody Game createGame(HttpSession session) {

        // TODO: using an fake account
        Account player = new Account();
        player.setId(10);
        player.setPlayer_name("fake_player");
        player.setPassword("fake_password");
        player.setManagement_status(true);

        // get all target word
        String[] wordList = gameService.loadWordList();

        Game newGame = new Game(UUID.randomUUID().toString(), wordList[(new Random(System.nanoTime()).nextInt(wordList.length))], player.getId());
        gameService.saveNewGame(newGame);
        return newGame;
    }

    /**
     * Updates a game resource when the player makes a guess.
      */
    @RequestMapping(value = "/game/{id}", method=RequestMethod.PUT)
    public @ResponseBody Game makeGuess(@PathVariable String id,
                                        @RequestParam(value="letter") String letter, HttpSession session) {

        Game game = gameService.getGame(id);

        if (game.getGameState()) {
            // In case the player type more than one character, take the first one
            String singleLetter = String.valueOf(letter.charAt(0));

            gameService.makeGuess(game, singleLetter);
        }
        return game;
    }

}
