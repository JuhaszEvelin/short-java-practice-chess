package com.codecool.chess;

import java.util.Objects;

public class Position {
    private int x;
    private int y;

    Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    boolean isOnBoard(){
        return x < Board.getSize() && y < Board.getSize();
    }

    Position calculatePositionAfterMove(Movement movement){
        return new Position(x + movement.getDeltaX(), y + movement.getDeltaY());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return x == position.x &&
                y == position.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
