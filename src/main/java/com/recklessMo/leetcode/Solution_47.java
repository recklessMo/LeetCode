package com.recklessMo.leetcode;


import java.util.*;

public class Solution_47 {

    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new LinkedList<>();
        search(nums, result, new LinkedList<>(), 0, nums.length);
        return result;
    }

    private void search(int[] nums, List<List<Integer>> result, List<Integer> temp, int start, int len){
        if(start == len){
            result.add(new LinkedList<>(temp));
            return;
        }
        Set<Integer> appeared = new HashSet<>();
        for(int i = start; i < len; i++){
            if(!appeared.contains(nums[i])){
                appeared.add(nums[i]);
                swap(nums, start, i);
                temp.add(nums[start]);
                search(nums, result, temp, start + 1, len);
                temp.remove(temp.size() - 1);
                swap(nums, start, i);
            }
        }
    }

    private void swap(int[] nums, int i, int j){
        int x = nums[i];
        nums[i] = nums[j];
        nums[j] = x;
    }

    public static void main(String[] args){

    }


}
