package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;


public class Solution_26 {

    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        int pos = -1;
        int i = 0;
        while(i < len){
            if(i == 0 || nums[pos] != nums[i]){
                pos++;
                nums[pos] = nums[i];
            }
            i++;
        }
        return pos + 1;
    }


    public int remove(int[] nums){
        int cnt = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                cnt++;
            }else{
                nums[i - cnt] = nums[i];
            }
        }
        return nums.length - cnt;
    }

    public static void main(String[] args){



    }


}
