package com.service.impl;

import com.dao.GameDao;
import com.domain.Game;
import com.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    // Keep track of where the guessed letters fit into the word
    private void updateCurrentGuess(Game game, String letter) {
        StringBuilder buffer = new StringBuilder(game.getCurrentGuess());
        String targetWord = game.getWord();
        char character = letter.toCharArray()[0];
        int index = targetWord.indexOf(letter);

        while (index >= 0) {
            buffer.setCharAt(index, character);
            index = targetWord.indexOf(character, index + 1);
        }

        game.setCurrentGuess(buffer.toString());
    }

    // A guess is correct when the letter exists and hasn't already been played.
    public void makeGuess(Game game, String letter) {
        if (game.getWord().contains(letter) && !game.getCurrentGuess().contains(letter)) {
            updateCurrentGuess(game, letter);
        } else {
            game.reduceRemainingGuesses();
        }

        // Always keep the state uo to date after a guess
        game.updateState();

        gameDao.updateGame(game);
    }

    // Load all target words.
    public String[] loadWordList() {
        return gameDao.loadWordList();
    }

    // Save new game into database.
    public void saveNewGame(Game newGame) {
        System.out.println("Business layer: save game info.");
        gameDao.saveNewGame(newGame);
    }

    // find game by id.
    public Game getGame(String id) {
        System.out.println("Business layer: get game by id.");
        return gameDao.getGame(id);
    }

}
