package com.controller;

import com.domain.Account;
import com.domain.Game;
import com.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Random;

@Controller
@RequestMapping("/game")
public class GameController {

    @Autowired
    private GameService gameService;
    @Autowired
    private HttpServletRequest request;

    /**
     * creat a new Hangman game.
     * @return forward to game page.
     */
    @RequestMapping(value="/newGame")
    public String newGame() {

        // TODO: using an fake account
        Account player = new Account();
        player.setId(10);
        player.setPlayer_name("fake_player");
        player.setPassword("fake_password");
        player.setManagement_status(true);

        // get all target word
        String[] wordList = gameService.loadWordList();
        // initialize a new hangman game.
        Game newGame = new Game(wordList[(new Random(System.nanoTime()).nextInt(wordList.length))], player.getId());

        gameService.saveNewGame(newGame);
        return "newGame";

    }

}
