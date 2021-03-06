package com.recklessMo.leetcode;


import java.util.HashMap;
import java.util.Map;

public class Solution_560 {


    public int subarraySum(int[] A, int S) {
        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, 1);

        int sum = 0;
        int totalCount = 0;
        for(int i = 0; i < A.length; i++) {
            sum += A[i];
            int prev = sum - S;
            Integer prevCount = sumMap.get(prev);
            if(prevCount != null){
                totalCount += prevCount;
            }

            Integer curCount = sumMap.get(sum);
            if(curCount == null){
                sumMap.put(sum, 1);
            }else{
                sumMap.put(sum, curCount + 1);
            }
        }

        return totalCount;
    }


    public static void main(String[] args) {

        Solution_560 test = new Solution_560();
        int[] nums = new int[]{1,1,1};

        System.out.println(test.subarraySum(nums, 2));

    }


}
