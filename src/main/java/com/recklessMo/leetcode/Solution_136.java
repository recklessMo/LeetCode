package com.recklessMo.leetcode;


import java.util.HashMap;

public class Solution_136 {

    public int singleNumber(int[] nums) {
        int result = 0;
        for(int i = 0; i < nums.length; i++){
            result ^= nums[i];
        }
        return result;
    }


    public static void main(String[] args){
        Solution_136 temp = new Solution_136();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
