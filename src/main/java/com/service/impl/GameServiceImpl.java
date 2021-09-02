package com.service.impl;

import com.dao.GameDao;
import com.domain.Game;
import com.domain.GameState;
import com.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("gameService")
public class GameServiceImpl implements GameService {

    @Autowired
    private GameDao gameDao;

    // reduce the number of remaining guesses by 1.
    public void reduceRemainingGuesses(Game game) {
        game.setRemainingGuesses(game.getRemainingGuesses()-1);
    }

    // update game state.
    public void updateState(Game game) {
        if (game.getWord().equals(game.getCurrentGuess())) {
            game.setGameState(GameState.WON);
        } else if (game.getRemainingGuesses() <= 0) {
            game.setGameState(GameState.LOST);
        }

        gameDao.updateGame(game);
    }

    // Keep track of where the guessed letters fit into the word
    public void updateCurrentGuess(Game game, String letter) {
        StringBuffer buffer = new StringBuffer(game.getCurrentGuess());
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
            reduceRemainingGuesses(game);
        }

        // Always keep the state uo to date after a guess
        updateState(game);
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
