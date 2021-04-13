package com.codecool.chess;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BoardTest {
    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsFalseIfKnightNotFound() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","wK"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertFalse(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnLeftTwoDownOne() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" ","wK"," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnLeftTwoUpOne() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" ","wK"," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnLeftOneUpTwo() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," ","wK"," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnRightOneUpTwo() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," ","wK"," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnRightTwoUpOne() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," ","wK"," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnRightTwoDownOne() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," ","wK"," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnRightOneDownTwo() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," ","wK"," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsTrueIfKingAttackedOnLeftOneDownTwo() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," ","wK"," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertTrue(board.isWhiteKingAttackedByBlackKnight());
    }

    @Test
    void test_isWhiteKingAttackedByBlackKnight_returnsFalseIfKingIsNotAttacked() throws InvalidChessBoardException, WhiteKingNotFoundException {
        String[][] squares = {
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","bk"," "," "," "," "},
                {" "," "," "," "," "," "," "," "},
                {" "," "," ","wK"," "," "," "," "},
                {" "," "," "," "," "," "," "," "}
        };
        Board board = new Board(squares);
        Assertions.assertFalse(board.isWhiteKingAttackedByBlackKnight());
    }
}