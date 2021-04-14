package com.codecool.chess;

class ChessStand {
    private String blackPlayerName;
    private Board board;

    ChessStand(String blackPlayerName, Board board) {
        this.blackPlayerName = blackPlayerName;
        this.board = board;
    }

    String getBlackPlayerName() {
        return blackPlayerName;
    }

    Board getBoard() {
        return board;
    }
}
