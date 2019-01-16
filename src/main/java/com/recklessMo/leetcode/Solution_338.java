package com.recklessMo.leetcode;


public class Solution_338 {


    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        for(int i = 1; i <= num; i++){
            result[i] = result[i >> 1] + i % 2;
        }
        return result;
    }

    public int[] countBits1(int num) {
        int[] result = new int[num + 1];
        for(int i = 1; i <= num; i++){
            result[i] = result[i & (i - 1)] + 1;
        }
        return result;
    }


    public static void main(String[] args){
        Solution_338 temp = new Solution_338();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
