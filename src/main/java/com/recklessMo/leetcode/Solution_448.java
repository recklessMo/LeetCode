package com.recklessMo.leetcode;


import java.util.LinkedList;
import java.util.List;

public class Solution_448 {


    public List<Integer> findDisappearedNumbers(int[] nums) {

        List<Integer> result = new LinkedList<>();

        int j = 0;
        while(j < nums.length){
            int temp = nums[j];
            int next = nums[temp - 1];
            if(temp == next){
                j++;
            }else {
                nums[j] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(nums[i] != i + 1){
                result.add(i + 1);
            }
        }

        return result;
    }



    public static void main(String[] args){
        Solution_448 temp = new Solution_448();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
