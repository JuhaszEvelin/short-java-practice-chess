package com.codecool.chess;

public class Position {
    private int x;
    private int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public boolean isOnBoard(){
        return x < Board.getSIZE() && y < Board.getSIZE();
    }

    public Position calculatePositionAfterMove(Movement movement){
        return new Position(x + movement.getDeltaX(), y + movement.getDeltaY());
    }
}
