package com.example.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class Board {
    Space[][] currentBoard = new Space[8][8];
    public void fillBoard() {
        //Fills the empty spaces
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                currentBoard[i][j] = new Space();
            }
        }
    }

    public Board() {
        fillBoard();
        currentBoard[3][3].piece = new Piece();
    }

    public boolean handleMove(String move) {
        return false;
    }
}
