package com.codecool.chess;

class Movement {
    private int deltaX;
    private int deltaY;

    Movement(int deltaX, int deltaY) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
    }

    int getDeltaX() {
        return deltaX;
    }

    int getDeltaY() {
        return deltaY;
    }
}
