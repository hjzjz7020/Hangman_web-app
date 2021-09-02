package com.service;

import com.domain.Game;

public interface GameService {

    // A guess is correct when the letter exists and hasn't already been played.
    void update(Game game, String letter);

    // Save new game into database.
    void insert(Game newGame);

    // Creat a new game using a random word.
    Game createNewGame();

    // find game by id.
    Game select(String id);
}
