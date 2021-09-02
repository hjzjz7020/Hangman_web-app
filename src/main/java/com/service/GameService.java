package com.service;

import com.domain.Game;

public interface GameService {

    // A guess is correct when the letter exists and hasn't already been played.
    void makeGuess(Game game, String letter);

    // Load all target words.
    String[] loadWordList();

    // Save new game into database.
    void saveNewGame(Game newGame);

    // find game by id.
    Game getGame(String id);
}
