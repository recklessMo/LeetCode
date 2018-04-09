package com.recklessMo.leetcode;


public class Solution_27 {


    public int removeElement(int[] nums, int val) {
        int len = nums.length;
        int pos = -1;
        int start = 0;
        while(start < len){
            if(nums[start] != val){
                nums[++pos] = nums[start];
            }
            start++;
        }
        return pos + 1;
    }

    public static void main(String[] args){



    }


}
