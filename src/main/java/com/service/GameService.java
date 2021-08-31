package com.service;

import com.domain.Game;

public interface GameService {

    // reduce the number of remaining guesses by 1.
    void reduceRemainingGuesses(Game game);

    // update game state.
    void updateState(Game game);

    // Keep track of the where the guessed letters fit into the word
    void updateCurrentGuess(Game game, String letter);

    // A guess is correct when the letter exists and hasn't already been played.
    void makeGuess(Game game, String letter);

    // Load all target words.
    String[] loadWordList();

    // Save new game into database.
    void saveNewGame(Game newGame);
}
