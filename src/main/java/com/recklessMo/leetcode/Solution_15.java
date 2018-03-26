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
public class Solution_15 {


    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new LinkedList<>();
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0; i < len; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            int total = -nums[i];
            int j = i + 1,k = len - 1;
            while(j < k){
                if(nums[j] + nums[k] > total){
                    k--;
                }else if(nums[j] + nums[k] < total){
                    j++;
                }else{
                    res.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    k--;
                    while(j < k && nums[k] == nums[k + 1]){
                        k--;
                    }
                }
            }
        }
        return res;
    }

}
