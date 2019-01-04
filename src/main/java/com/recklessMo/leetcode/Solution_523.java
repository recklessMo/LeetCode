package com.recklessMo.leetcode;


import java.util.*;

public class Solution_523 {


    public boolean checkSubarraySum1(int[] nums, int k) {
        int len = nums.length;
        if (len <= 1) {
            return false;
        }

        long[] sum = new long[len];
        for (int i = 0; i < len; i++) {
            sum[i] = nums[i];
            if (i >= 1) {
                sum[i] += sum[i - 1];
            }
        }

        for (int j = 1; j < len; j++) {
            if (sum[j] % k == 0) {
                return true;
            }
        }

        for (int i = 0; i < len; i++) {
            for (int j = i + 2; j < len; j++) {
                if ((sum[j] - sum[i]) % k == 0) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean checkSubarraySum(int[] nums, int k) {
        Map<Long, Integer> resultMap = new HashMap<>();
        long sum = 0;
        resultMap.put(0L, -1);
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (k != 0) {
                sum %= k;
            }
            Integer prev = resultMap.get(sum);
            if (prev != null) {
                if (i - prev > 1) {
                    return true;
                }
            } else {
                resultMap.put(sum, i);
            }
        }
        return false;
    }


    public static void main(String[] args) {

        Solution_523 test = new Solution_523();
        int[] nums = new int[]{0, 0};

        System.out.println(test.checkSubarraySum(nums, 0));

    }


}
