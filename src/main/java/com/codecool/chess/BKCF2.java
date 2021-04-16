package com.codecool.chess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BKCF2 {

    String calculateBlackKnightChampion(String fileName) {
        Map<String, Integer> res = new HashMap<>();
        try (FileReader fileReader = new FileReader(fileName); BufferedReader reader = new BufferedReader(fileReader)) {
            String line = "";
            while ((line = reader.readLine()) != null) {
                String name = line;
                int[] bk = new int[2];
                int[] wK = new int[2];
                for (int i = 0; i < 8; i++) {
                    String[] row = reader.readLine().split(",");
                    oneRound(bk, wK, i, row);
                }
                if ((Math.abs(bk[0] - wK[0]) == 1
                        && Math.abs(bk[1] - wK[1]) == 2)
                        || (Math.abs(bk[0] - wK[0]) == 2
                        && Math.abs(bk[1] - wK[1]) == 1)) {
                    res.put(name, res.getOrDefault(name, 0) + 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return findWinner(res);
    }

    private void oneRound(int[] bk, int[] wK, int i, String[] row) {
        for (int j = 0; j < 8; j++) {
            if (row[j].equals("bk")) {
                bk[0] = i;
                bk[1] = j;
            }
            if (row[j].equals("wK")) {
                wK[0] = i;
                wK[1] = j;
            }
        }
    }

    private String findWinner(Map<String, Integer> res) {
        String winner = "";
        int max = 0;
        for (String name : res.keySet()) {
            if (res.get(name) > max) {
                winner = name;
                max = res.get(name);
            } else if (res.get(name) == max) {
                winner = "draw";
            }
        }
        return winner;
    }

}
