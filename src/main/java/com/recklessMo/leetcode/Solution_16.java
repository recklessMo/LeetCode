package com.recklessMo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 *
 *
 * 还尝试了一下搜索算法，
 * 发现对于这种组合型的搜索，可以采用多森林搜索法或者单树搜索法！
 *
 * 后面应该还会碰见很多，希望能注意~
 *
 *
 * 15，16核心就是双指针。
 *
 *
 */
public class Solution_16 {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        int result = 0;
        int gap = Integer.MAX_VALUE;
        for(int i = 0; i < len; i++){
            int total = target - nums[i];
            int j = i + 1, k = len - 1;
            while(j < k){
                int sum = nums[j] + nums[k];
                if(Math.abs(sum + nums[i] - target) < gap){
                    gap = Math.abs(sum + nums[i] - target);
                    result = sum + nums[i];
                }
                if(sum > total){
                    k--;
                }else if(sum == total){
                    return target;
                }else{
                    j++;
                }
            }
        }

        return result;
    }




}
