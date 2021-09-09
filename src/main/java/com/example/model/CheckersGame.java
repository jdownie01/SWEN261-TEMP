package com.example.model;

import java.util.logging.Logger;

//TODO: retrofit this class to work with our new structure
//TODO: keep the methods the webserver relies on and slowly change everything over

/**
 * A single "guessing game".
 *
 * @author <a href='mailto:bdbvse@rit.edu'>Bryan Basham</a>
 * @author <a href='mailto:jrv@se.rit.edu'>Jim Vallino</a>
 */
public class CheckersGame {
    // Attributes
    private Player playerOne;
    private Player playerTwo;
    private Player currentMove;
    private Board currentBoard;
    private Player winner;

    private String name;


    // Constants
    private static final Logger LOG = Logger.getLogger(CheckersGame.class.getName());

    //private int howManyGuessesLeft = NUM_OF_GUESSES;
    /**
     * Create a guessing game with a known number.
     *
     * @throws IllegalArgumentException when the {@code numberToGuess} is out of range
     */
    public CheckersGame() {
        //TODO: Add validation for new checker games
        /*
        if (numberToGuess < 0 || numberToGuess >= UPPER_BOUND) {
            throw new IllegalArgumentException("numberToGuess is out of range");
        }
         */
        //
        LOG.fine("Game created ");
    }

    public CheckersGame(String name) {
        this.name = name;
        LOG.fine("Game created ");
    }

    //
    // Constructors
    //

    /**
     * Queries whether the game is at the beginning; meaning no guesses have yet
     * been made.
     *
     * @return true if no guesses have been made, otherwise, false
     */
    public synchronized boolean isGameBeginning() {
        return true;
    }

    public synchronized String getName() {
        return name;
    }

    //
    // Public methods
    //

    /**
     * Queries whether the supplied guess is a valid guess. This does not actually
     * issue a guess.
     *
     * @param guess The hypothetical guess.
     * @return true if the guess falls within the game bounds, otherwise, false
     */
    public boolean isValidGuess(int guess) {
        return guess >= 0 && guess < 0;
    }

    public synchronized boolean makeMove(String move) {
        return currentBoard.handleMove(move);
    }

    /**
     * Queries whether the game is finished.
     *
     * @return true if the game was won or lost with the last guess
     */
    public synchronized boolean isFinished() {
        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public synchronized String toString() {
        return "{Game " + 3 + "}";
    }

    // The results for a player making a guess.
    public enum GameState {NOT_STARTED, STARTED, OVER}
}
