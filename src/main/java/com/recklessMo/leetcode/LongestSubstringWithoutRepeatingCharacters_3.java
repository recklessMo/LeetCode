package com.recklessMo.leetcode;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithoutRepeatingCharacters_3 {

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
        B b = new B();
        b.z();
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


class A {

    public int i = 1;

    public void z(){
        System.out.println(this);
        ((B)this).x();
    }

}


class B extends  A{

    public int i = 2;

    public void x(){
        System.out.println(this.i);
        System.out.println(super.i);
        System.out.println(super.equals(this));
    }

}