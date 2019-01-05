package com.recklessMo.leetcode;


public class Solution_169 {

    public int majorityElement(int[] nums) {
        int cnt = 0;
        int element = -1;
        for(int i = 0; i < nums.length; i++){
            if(cnt == 0){
                element = nums[i];
                cnt = 1;
            }else{
                if(element == nums[i]){
                    cnt++;
                }else{
                    cnt--;
                }
            }
        }
        return element;
    }


    public static void main(String[] args){
        Solution_169 temp = new Solution_169();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(temp.majorityElement(new int[]{2,3,2,2,0}));
    }


}
