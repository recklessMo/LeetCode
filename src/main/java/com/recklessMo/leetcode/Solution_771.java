package com.recklessMo.leetcode;


import java.util.*;

public class Solution_771 {


    public int numJewelsInStones(String J, String S) {
        boolean[] flag = new boolean[256];
        for(int i = 0; i < J.length(); i++){
            flag[J.charAt(i)] = true;
        }
        int count = 0;
        for(int i = 0; i < S.length(); i++){
            if(flag[S.charAt(i)]){
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {

        Solution_771 test = new Solution_771();

    }


}
