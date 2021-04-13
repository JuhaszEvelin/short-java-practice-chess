package com.codecool.chess;

import java.util.ArrayList;
import java.util.List;

public class Board {
    private static final int SIZE = 8;
    private String[][] squares;

    public Board(String[][] squares) throws InvalidChessBoardException {
        if(!hasValidSize(squares)){
            throw new  InvalidChessBoardException();
        }
        this.squares = squares;
    }

    public String[][] getSquares() {
        return squares;
    }

    public static int getSize() {
        return SIZE;
    }

    private boolean hasValidSize(String[][] squares){
        return squares.length == SIZE && squares[0].length == SIZE;
    }

    private List<BlackKnight> collectBlackKnights(){
        List<BlackKnight> blackKnights = new ArrayList<>();
        for (int x = 0; x < Board.SIZE; x++) {
            for (int y = 0; y < Board.SIZE; y++) {
                Position currentPosition = new Position(x,y);
                String pieceCode = squares[x][y];
                if(pieceCode.equals(BlackKnight.CODE_FOR_BLACK_KNIGHT)){
                    blackKnights.add(new BlackKnight(currentPosition));
                }
                if (blackKnights.size() == 2){
                    return blackKnights;
                }
            }
        }
        return blackKnights;
    }

    private WhiteKing findWhiteKing() throws WhiteKingNotFoundException {
        for (int x = 0; x < Board.SIZE; x++) {
            for (int y = 0; y < Board.SIZE; y++) {
                String pieceCode = squares[x][y];
                if(pieceCode.equals(WhiteKing.CODE_FOR_WHITE_KING)){
                    return new WhiteKing(new Position(x,y));
                }
            }
        }
        throw new WhiteKingNotFoundException();
    }

    public boolean isWhiteKingAttackedByBlackKnight() throws WhiteKingNotFoundException {
        List<BlackKnight> blackKnights = collectBlackKnights();
        WhiteKing whiteKing = findWhiteKing();
        return  blackKnights.stream()
                .flatMap(blackKnight -> blackKnight.getAttackedPositions().stream())
                .anyMatch(attackedPosition -> whiteKing.getPosition().equals(attackedPosition));
    }
}
