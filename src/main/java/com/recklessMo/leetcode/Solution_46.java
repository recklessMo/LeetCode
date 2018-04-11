package com.recklessMo.leetcode;


import java.util.LinkedList;
import java.util.List;

public class Solution_46 {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        search(result, new LinkedList<>(), nums, 0, nums.length);
        return result;
    }

    private void search(List<List<Integer>> result, List<Integer> temp, int[] nums, int start, int len){
        if(start == len){
            result.add(new LinkedList<>(temp));
            return;
        }
        for(int i = start; i < len; i++){
            swap(nums, start, i);
            temp.add(nums[start]);
            search(result, temp, nums, start + 1, len);
            temp.remove(temp.size() - 1);
            swap(nums, start, i);
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
