package com.recklessMo.leetcode;


import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class Solution_438 {


    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> resultList = new LinkedList<>();

        if(s == null || s.length() == 0 || p == null || p.length() == 0){
            return resultList;
        }

        int[] hash = new int[256];
        for(char c : p.toCharArray()){
            hash[c]++;
        }

        int left = 0, right = 0, count = p.length();
        while(right < s.length()){

            if(hash[s.charAt(right)] >= 1){
                count--;
            }
            hash[s.charAt(right)]--;
            right++;

            if(count == 0){
                resultList.add(left);
            }

            if(right - left == p.length()){
                if(hash[s.charAt(left)] >= 0){
                    count++;
                }
                hash[s.charAt(left)]++;
                left++;
            }
        }
        return resultList;
    }

    public static void main(String[] args) {
        Solution_438 temp = new Solution_438();

        List<Integer> resultList = temp.findAnagrams("cbaebabacd", "abc");

        for(Integer a : resultList){
            System.out.print(a + "  ");
        }
        System.out.println();

    }


}
