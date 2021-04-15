package com.codecool.chess;

import java.util.ArrayList;
import java.util.List;

public class RoundList {

    List<Round> roundList = new ArrayList<>();

    public void add(Round round) {
        roundList.add(round);
    }

    private List<Round> getRoundList() {
        return new ArrayList<>(roundList);
    }

    public String getWinner() {
        String player1 = getRoundList().get(0).getPlayerName();
        String player2 = "";
        int counterPlayer1 = 0;
        int counterPlayer2 = 0;
        for (Round round : getRoundList()) {
            String roundPlayerName = round.getPlayerName();
            boolean roundIsWinner = round.isWinner();
            if (player1.equals(roundPlayerName) && roundIsWinner){
                counterPlayer1++;
            } else if (roundIsWinner){
                player2 = roundPlayerName;
                counterPlayer2++;
            }
        }
        if (counterPlayer1 == counterPlayer2){
            return "draw";
        } else {
            return counterPlayer1 > counterPlayer2 ? player1 : player2;
        }
    }

}
