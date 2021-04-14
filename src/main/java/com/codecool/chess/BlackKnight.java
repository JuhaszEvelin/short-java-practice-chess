package com.codecool.chess;

import java.util.ArrayList;
import java.util.List;

class BlackKnight extends ChessPiece{
    static final String PIECE_CODE = "bk";
    private static final List<Movement> RELATIVE_MOVES = new ArrayList<>(){{
        add(new Movement(2,1));
        add(new Movement(2,-1));
        add(new Movement(-2,1));
        add(new Movement(-2,-1));
        add(new Movement(1,2));
        add(new Movement(-1,2));
        add(new Movement(1,-2));
        add(new Movement(-1,-2));
    }};

    BlackKnight(Position position) {
        super(PIECE_CODE, position);
    }

    List<Position> getAttackedPositions(){
       List<Position> attackedPositions = new ArrayList<>();
        for (Movement relativeMove : RELATIVE_MOVES) {
            Position positionAfterMove = position.calculatePositionAfterMove(relativeMove);
            if(positionAfterMove.isOnBoard()){
                attackedPositions.add(positionAfterMove);
            }
        }
        return attackedPositions;
    }
}