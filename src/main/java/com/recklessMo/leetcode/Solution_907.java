package com.recklessMo.leetcode;


public class Solution_907 {

    public int sumSubarrayMins(int[] A) {
        int sum = 0;
        for(int i = 0; i < A.length; i++){

            int data = A[i];
            int leftIndex = i;
            while(leftIndex >= 0 && A[leftIndex] >= data){

            }

        }

        return 0;
    }

    public static void main(String[] args) {

        Solution_907 test = new Solution_907();
        int[] nums = new int[]{1,0,1,0,1};
        System.out.println(test.sumSubarrayMins(nums));

    }


}
