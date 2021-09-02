package com.service.impl;

import com.dao.GameDao;
import com.domain.Game;
import com.service.GameService;
import com.service.GameWordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;
    @Autowired
    private GameWordService gameWordService;

    public void update(Game game, String letter) {

        game.makeGuess(letter);
        game.updateState();

        gameDao.update(game);
    }

    // Save new game into database.
    public void insert(Game newGame) {
        System.out.println("Business layer: save game info.");
        gameDao.insert(newGame);
    }

    // Creat a new game using a random word.
    public Game createNewGame() {
        // get all target word
        String[] wordList = gameWordService.loadWordList();

        Game newGame = new Game(wordList[randomIndex(wordList)]);
        insert(newGame);

        return newGame;
    }

    // find game by id.
    public Game select(String id) {
        System.out.println("Business layer: get game by id.");
        return gameDao.select(id);
    }

    // generate a random word list index.
    private int randomIndex(String[] wordList) {
        return new Random(System.nanoTime()).nextInt(wordList.length);
    }

}
