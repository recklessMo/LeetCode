package com.recklessMo.leetcode;

public class LongestPalindromicSubstring_5 {

    private int total = 0;
    private String result = null;

    public String longestPalindrome(String s) {
        if(s == null || s.equals("")){
            return null;
        }
        int len = s.length();
        for(int i = 0; i < len; i++){
            cal(s, i, i, len);
            if(i + 1 < len && s.charAt(i) == s.charAt(i + 1)){
                cal(s, i, i+1, len);
            }
        }
        return result;
    }

    private void cal(String s, int left, int right, int len){
        int cnt = 1;
        while(left - cnt >=0 && right + cnt<len && s.charAt(left-cnt) == s.charAt(right + cnt)){
            cnt++;
        }
        if(right - left + cnt * 2 + 1 > total){
            total = right - left + cnt * 2 + 1;
            result = s.substring(left - cnt + 1, right + cnt);
        }
    }


    public static void main(String[] args){
        LongestPalindromicSubstring_5 temp = new LongestPalindromicSubstring_5();
        System.out.println(temp.longestPalindrome("abba"));
    }


}
