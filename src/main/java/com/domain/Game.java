package com.domain;

import java.io.Serializable;

public class Game implements Serializable {

    private String id;
    private String word;
    private GameState gameState;
    private int playerId;
    private int letterCount;
    private int remainingGuesses;
    private String currentGuess;

    /**
     * Constructor method.
     * @param id game id.
     * @param state game state.
     * @param word target word.
     * @param playerId ID of current player.
     */
    public Game(String id, int state, String word, int playerId) {
        this.id = id;
        this.word = word;
        this.playerId = playerId;
        if (state == 1) {
            this.gameState = GameState.WON;
        } else if (state == 0) {
            this.gameState = GameState.ACTIVE;
        } else {
            this.gameState = GameState.LOST;
        }
    }

    /**
     * Constructor method.
     * @param word target word.
     * @param playerId ID of current player.
     */
    public Game(String id, String word, int playerId) {
        this.id = id;
        this.word = word;
        this.playerId = playerId;
        this.remainingGuesses = 10;
        this.currentGuess = word.replaceAll(".", "_");
        this.letterCount = word.length();
        this.gameState = GameState.ACTIVE;
    }

    public String getId() {
        return id;
    }

    public int getLetterCount() {
        return letterCount;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getRemainingGuesses() {
        return remainingGuesses;
    }

    public void setRemainingGuesses(int remainingGuesses) {
        this.remainingGuesses = remainingGuesses;
    }

    public boolean getGameState() {
        return gameState == GameState.ACTIVE;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }

    public String getCurrentGuess() {
        return currentGuess;
    }

    public void setCurrentGuess(String currentGuess) {
        this.currentGuess = currentGuess;
    }

    public int getPlayerId() {
        return playerId;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }
}
