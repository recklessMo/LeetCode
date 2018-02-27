package com.recklessMo.rpc;

import java.util.List;

public class WildcardError {


    public static void add(List<? super Integer> dataList){
        dataList.add(2);
        dataList.add(1);
    }

    public int[] twoSum(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++){
            for(int j = i + 1; j < nums.length; j++){
                if(target == nums[i] + nums[j]){
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }

    public static void main(String[] args){


    }

}
