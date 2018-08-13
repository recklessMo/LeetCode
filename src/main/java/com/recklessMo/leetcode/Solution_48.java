package com.recklessMo.leetcode;


import java.util.*;

public class Solution_48 {


    public void rotate(int[][] matrix) {
        rotate180(matrix);
        rotateVertical(matrix);
    }


    public void rotate180(int[][] matrix){

        int row = matrix.length;
        if(row == 0){
            return;
        }
        int total = row - 1;

        for(int i = 0; i < row; i++){
            for(int j = 0; j < row - i; j++){
                int nx = total - j;
                int ny = total - i;

                int a = matrix[i][j];
                matrix[i][j] = matrix[nx][ny];
                matrix[nx][ny] = a;
            }
        }

    }

    public void rotateVertical(int[][] matrix){
        int row = matrix.length;
        if(row == 0){
            return;
        }

        int total = row - 1;
        for(int i = 0; i < row / 2; i++){
            int nx = total - i;
            for(int j = 0; j < row; j++){
                int a = matrix[i][j];
                matrix[i][j] = matrix[nx][j];
                matrix[nx][j] = a;
            }
        }

    }

    public static void main(String[] args){
        int[][] array = {{1,2,3},{4,5,6},{7,8,9}};
        new Solution_48().rotate(array);
    }


}
