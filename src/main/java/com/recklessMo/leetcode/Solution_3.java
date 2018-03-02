package com.recklessMo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class Solution_3 {

    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int startPos = -1;
        int result = 0;
        Map<Character, Integer> posMap = new HashMap<>();
        for(int i = 0; i < len; i++){
            Character single = s.charAt(i);
            Integer lastPos = posMap.get(single);
            if(lastPos != null){
                startPos = Math.max(lastPos, startPos);
            }
            if(i - startPos > result){
                result = i - startPos;
            }
            posMap.put(single, i);
        }
        return result;
    }


    public static void main(String[] args){
//        b.x();
//        int a = Integer.MIN_VALUE - 1;
//        System.out.println(a);
//        System.out.println(a + 1);
//            Integer a = 1;
//            Object b = (int)a;
//            Long c = (Long)b;
//        System.out.println(System.identityHashCode(int.class));
//        System.out.println(System.identityHashCode(Integer.TYPE));
//        System.out.println(System.identityHashCode(Integer.class));


    }

}

