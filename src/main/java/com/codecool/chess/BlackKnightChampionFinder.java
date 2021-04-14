package com.codecool.chess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class BlackKnightChampionFinder {
    private List<String> loadLinesFromFiles(String fileName){
        ArrayList<String> linesInFile = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = br.readLine()) != null) {
                linesInFile.add(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return linesInFile;
    }

    private List<ChessStand> importChessStands(String fileName) throws InvalidChessBoardException {
        List<ChessStand> chessStands = new ArrayList<>();
        List<String> linesInFile = loadLinesFromFiles(fileName);
        int index = -1;
        String blackPlayerName = "";
        String[][] squares = new String[8][8];
        for (String line : linesInFile) {
            if(index == -1){
                blackPlayerName = line;
            }else{
                squares[index]=line.split(",");
            }
            index++;
            if(index == 8){
                index = -1;
                chessStands.add(new ChessStand(blackPlayerName, new Board(squares)));
                squares = new String[8][8];
            }
        }
        return chessStands;
    }

    private HashMap<String,Integer> importPlayerStatistics(String fileName){
        HashMap<String,Integer> playerStatistics = new HashMap<>();
        try {
            List<ChessStand> chessStands = importChessStands(fileName);
            for (ChessStand chessStand : chessStands) {
                if(chessStand.getBoard().isWhiteKingAttackedByBlackKnight()){
                    if(playerStatistics.containsKey(chessStand.getBlackPlayerName())){
                        playerStatistics.put(chessStand.getBlackPlayerName(), playerStatistics.get(chessStand.getBlackPlayerName()) + 1);
                    } else {
                        playerStatistics.put(chessStand.getBlackPlayerName(), 1);
                    }
                }
            }
        } catch (InvalidChessBoardException e) {
            System.out.println("Chessboard has invalid size");
        } catch (WhiteKingNotFoundException e) {
            System.out.println("White king not found");
        }
        return playerStatistics;
    }

    private boolean isDraw(HashMap<String,Integer> playerStatistics){
        return playerStatistics.values().size() != playerStatistics.values().stream().distinct().count();
    }

    String calculateBlackKnightChampion(String fileName) {
        HashMap<String,Integer> playerStatistics = importPlayerStatistics(fileName);
        if(isDraw(playerStatistics)){
            return "draw";
        }
        return Collections.max(playerStatistics.entrySet(), Comparator.comparing(Map.Entry::getValue)).getKey();
    }
}
