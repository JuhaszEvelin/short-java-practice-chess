package com.codecool.chess;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class BlackKnightChampionFinder {

    List<String> results = new ArrayList<>();

    String calculateBlackKnightChampion(String fileName) {

        RoundList roundList = new RoundList();
        getData(fileName);
        String name;
        List<List<String>> res;

        while (!results.isEmpty()) {
            name = results.get(0);
            results.remove(0);
            res = getResultList();
            Round round = new Round(name, res);
            roundList.add(round);
        }
        return roundList.getWinner();
    }

    private List<List<String>> getResultList() {
        List<List<String>> res = new ArrayList<>();
        int rows = 8;
        while (rows > 0) {
            res.add(Arrays.asList(results.get(0).split(",")));
            results.remove(0);
            rows--;
        }
        return res;
    }

    private void getData(String fileName) {
        try (BufferedReader br = new BufferedReader(new FileReader(fileName))) {
            String line = "";
            while ((line = br.readLine()) != null) {
                results.add(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        BlackKnightChampionFinder bkcf = new BlackKnightChampionFinder();
        System.out.println(bkcf.calculateBlackKnightChampion("src/test/testfiles/test.csv"));
    }
}
