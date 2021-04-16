package com.codecool.chess;

import java.util.List;

public class Round {

    final String playerName;
    final List<List<String>> result;
    private boolean isWinner;
    final int[][] blackKnightChessMatPosition = {
            {-1, -2},
            {-1, 2},
            {1, -2},
            {1, 2},
            {2, 1},
            {2, -1},
            {-2, 1},
            {-2, -2}
    };

    public Round(String playerName, List<List<String>> result) {
        this.playerName = playerName;
        this.result = result;
        setWinner();
    }

    public String getPlayerName() {
        return playerName;
    }

    private List<List<String>> getResult() {
        return result;
    }

    public boolean isWinner() {
        return isWinner;
    }

    private void setWinner() {
        int wkRowIndex = 0;
        int wkColIndex = 0;
        for (int i = 0; i < getResult().size(); i++) {
            if (getResult().get(i).indexOf("wK") != -1) {
                wkColIndex = getResult().get(i).indexOf("wK");
                wkRowIndex = i;
            }
        }
        for (int[] bkPoz : blackKnightChessMatPosition) {
            int checkMatRow = bkPoz[0] + wkRowIndex;
            int checkMatCol = bkPoz[1] + wkColIndex;
            if (checkMatRow >= 0
                    && checkMatRow <= 7
                    && checkMatCol >= 0
                    && checkMatCol <= 7
                    && getResult().get(checkMatRow).get(checkMatCol).equals("bk")){
                isWinner = true;
            }
        }
    }
}
