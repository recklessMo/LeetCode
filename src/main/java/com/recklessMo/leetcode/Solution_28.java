package com.recklessMo.leetcode;


public class Solution_28 {


    public int strStr(String haystack, String needle) {
        if(haystack.equals("") && needle.equals("")){
            return 0;
        }
        for(int i = 0; i < haystack.length(); i++){
            int pos = i;
            for(int j = 0; j < needle.length() && pos < haystack.length(); j++, pos++){
                if (haystack.charAt(pos) != needle.charAt(j)){
                    break;
                }
            }
            if(pos - i == needle.length()){
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args){

    }


}
