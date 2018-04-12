package com.recklessMo.leetcode;


import java.util.HashSet;
import java.util.Set;

public class Solution_36 {


    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> row = new HashSet<>();
            Set<Character> col = new HashSet<>();
            Set<Character> box = new HashSet<>();
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.' && !row.add(board[i][j])) {
                    return false;
                }
                if (board[j][i] != '.' && !col.add(board[j][i])) {
                    return false;
                }
                if (board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3] != '.' && !box.add(board[i / 3 * 3 + j / 3][i % 3 * 3 + j % 3])) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {

    }


}
