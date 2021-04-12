package com.codecool.chess;

public class ChessPiece {//Todo checkolni hogy ez az osztály nem felesleges e
    private String code;
    protected Position position;

    public ChessPiece(String code, Position position) {
        this.code = code;
        this.position = position;
    }

    public Position getPosition() {
        return position;
    }

    public String getCode() {
        return code;
    }
}
