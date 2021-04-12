package com.codecool.chess;

import java.util.ArrayList;
import java.util.List;

public class BlackKnight {
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

    private Position position;

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
