package com.codecool.chess;

import java.util.ArrayList;
import java.util.List;

public class BlackKnight extends ChessPiece{
     static final String CODE_FOR_BLACK_KNIGHT = "bk";//Todo itt lehet elég az hogy code vagy ilyesmi
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

    public BlackKnight(Position position) {
        super(CODE_FOR_BLACK_KNIGHT, position);
    }

    public List<Position> getAttackedPositions(){
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
