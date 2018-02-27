package com.recklessMo.leetcode;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;

public class TwoSum_1 {

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

    public int[] twoSum1(int[] nums, int target){
        Map<Integer, Integer> posMap = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            Integer other = posMap.get(target - nums[i]);
            if(other != null){
                return new int[]{other, i};
            }
            posMap.put(nums[i], i);
        }
        return null;
    }


    public static void main(String[] args){
        char[] chars = Character.toChars(0x1F602 );
        String x  = new String(chars);
        System.out.println(x + "   " + x.length());

        x += x;
        byte[] data = x.getBytes(Charset.forName("UTF-16"));
        System.out.printf("%x", data[0]);
        System.out.printf("%x", data[1]);
        System.out.printf("%x", data[2]);
        System.out.printf("%x", data[3]);


        System.out.println(x + "   " + x.length());
    }

}
