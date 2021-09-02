package com.domain;

import java.io.Serializable;

public class Game implements Serializable {

    private String id;
    private String word;
    private GameState gameState;
    private int letterCount;
    private int remainingGuesses;
    private String currentGuess;

    /**
     * Constructor method.
     * @param id game id.
     * @param state game state.
     * @param word target word.
     */
    public Game(String id, int state, String word) {
        this.id = id;
        this.word = word;
        this.remainingGuesses = 10;
        this.currentGuess = word.replaceAll(".", "_");
        this.letterCount = word.length();
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
     */
    public Game(String id, String word) {
        this.id = id;
        this.word = word;
        this.remainingGuesses = 10;
        this.currentGuess = word.replaceAll(".", "_");
        this.letterCount = word.length();
        this.gameState = GameState.ACTIVE;
    }

    /**
     * Constructor method.
     * @param word target word.
     */
    public Game(String id, String word, int state, int remainingGuesses, String currentGuess) {
        this.id = id;
        this.word = word;
        if (state == 1) {
            this.gameState = GameState.WON;
        } else if (state == 0) {
            this.gameState = GameState.ACTIVE;
        } else {
            this.gameState = GameState.LOST;
        }
        this.remainingGuesses = remainingGuesses;
        this.currentGuess = currentGuess.replaceAll("_", "_");
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

}
