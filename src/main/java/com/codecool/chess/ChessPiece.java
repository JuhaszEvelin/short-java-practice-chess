package com.codecool.chess;

class ChessPiece {//Todo checkolni hogy ez az osztály nem felesleges e
    private String code;
    Position position;

    ChessPiece(String code, Position position) {
        this.code = code;
        this.position = position;
    }

    Position getPosition() {
        return position;
    }
}
