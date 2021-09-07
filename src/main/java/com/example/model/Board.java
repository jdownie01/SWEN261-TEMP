package com.example.model;

import java.util.ArrayList;
import java.util.Objects;

public class Board {
    private final ArrayList<ArrayList<Space>> currentBoard;

    public Board(ArrayList<ArrayList<Space>> currentBoard) {
        this.currentBoard = currentBoard;
    }

    public Board() {
        this.currentBoard = new ArrayList<>();
        this.currentBoard.add(new ArrayList<>());
        this.currentBoard.add(new ArrayList<>());
        this.currentBoard.add(new ArrayList<>());

        this.currentBoard.get(0).add(new Space());
        this.currentBoard.get(0).add(new Space());
        this.currentBoard.get(0).add(new Space());

        this.currentBoard.get(1).add(new Space());
        this.currentBoard.get(1).add(new Space());
        this.currentBoard.get(1).add(new Space());

        this.currentBoard.get(2).add(new Space());
        this.currentBoard.get(2).add(new Space());
        this.currentBoard.get(2).add(new Space());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Board)) return false;
        Board board = (Board) o;
        return Objects.equals(currentBoard, board.currentBoard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currentBoard);
    }

    public boolean handleMove(String move) {
        return false;
    }
}
