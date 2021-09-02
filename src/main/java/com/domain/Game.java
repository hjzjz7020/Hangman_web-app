package com.domain;

import java.io.Serializable;
import java.util.UUID;

public class Game implements Serializable {

    private final String id;
    private String word;
    private GameState gameState;
    private int remainingGuesses;
    private String currentGuess;

    /**
     * Constructor method.
     * @param id game id.
     * @param state game state.
     * @param word target word.
     */
    public Game(String id, GameState state, String word) {
        this.id = id;
        this.word = word;
        this.remainingGuesses = 10;
        this.currentGuess = word.replaceAll(".", "_");
        this.gameState = state;
    }

    /**
     * Constructor method.
     * @param word target word.
     */
    public Game(String word) {
        this.id = UUID.randomUUID().toString();
        this.word = word;
        this.remainingGuesses = 10;
        this.currentGuess = word.replaceAll(".", "_");
        this.gameState = GameState.ACTIVE;
    }

    /**
     * Constructor method.
     * @param word target word.
     */
    public Game(String id, String word, String state, int remainingGuesses, String currentGuess) {
        this.id = id;
        this.word = word;
        this.gameState = GameState.valueOf(state);
        this.remainingGuesses = remainingGuesses;
        this.currentGuess = currentGuess.replaceAll("_", "_");
    }

    public String getId() {
        return id;
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

    public GameState getGameState() {
        return gameState;
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

    // reduce the number of remaining guesses by 1.
    public void reduceRemainingGuesses() {
        this.setRemainingGuesses(this.getRemainingGuesses()-1);
    }

    // update game state.
    public void updateState() {
        if (this.getWord().equals(this.getCurrentGuess())) {
            this.setGameState(GameState.WON);
        } else if (this.getRemainingGuesses() <= 0) {
            this.setGameState(GameState.LOST);
        }
    }

    // Keep track of where the guessed letters fit into the word
    private void updateCurrentGuess(String letter) {
        StringBuilder buffer = new StringBuilder(this.getCurrentGuess());
        String targetWord = this.getWord();
        char character = letter.toCharArray()[0];
        int index = targetWord.indexOf(letter);

        while (index >= 0) {
            buffer.setCharAt(index, character);
            index = targetWord.indexOf(character, index + 1);
        }

        this.setCurrentGuess(buffer.toString());
    }

    // A guess is correct when the letter exists and hasn't already been played.
    public void makeGuess(String letter) {
        if (this.getWord().contains(letter) && !this.getCurrentGuess().contains(letter)) {
            updateCurrentGuess(letter);
        } else {
            this.reduceRemainingGuesses();
        }
    }
}
