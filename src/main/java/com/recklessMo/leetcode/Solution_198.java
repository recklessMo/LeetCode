package com.recklessMo.leetcode;



public class Solution_198 {


    public int rob(int[] nums) {
        int len = nums.length;
        if(len == 0){
            return 0;
        }
        int[] dp = new int[len];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            if (i == 1) {
                dp[i] = Math.max(nums[i], dp[i - 1]);
            } else {
                dp[i] = Math.max(nums[i] + dp[i - 2], dp[i - 1]);
            }
        }
        return dp[len - 1];
    }

    public static void main(String[] args){
        Solution_198 temp = new Solution_198();

        System.out.println(temp.rob(new int[]{2,7,9,3,1}));
    }


}
