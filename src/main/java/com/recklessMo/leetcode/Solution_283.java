package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

import java.util.Stack;

public class Solution_283 {


    public void moveZeroes(int[] nums) {

        int start = -1;
        int j = 0;
        while(j < nums.length){
            if(nums[j] != 0){
                start++;
                int temp = nums[start];
                nums[start] = nums[j];
                nums[j] = temp;
            }
            j++;
        }

    }


    public static void main(String[] args){
        Solution_283 temp = new Solution_283();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
