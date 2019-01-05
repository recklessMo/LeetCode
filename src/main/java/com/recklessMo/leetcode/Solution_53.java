package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

public class Solution_53 {


    public int maxSubArray(int[] nums) {

        int max = Integer.MIN_VALUE;

        int sum = 0;
        for(int i = 0; i < nums.length; i++){
            int total = nums[i];
            if(sum > 0){
                total = sum + nums[i];
            }
            if(total > max){
                max = total;
            }
            sum = total;
        }

        return max;
    }


    public static void main(String[] args) {

        Solution_53 test = new Solution_53();

        System.out.println(test.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));

    }


}
