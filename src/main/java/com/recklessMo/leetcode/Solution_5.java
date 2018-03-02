package com.recklessMo.leetcode;

public class Solution_5 {

    private int total = 0;
    private String result = null;

    /**
     *
     *     除了这种方法还可以采用dp的方法。
     *
     *  boolean dp[i][j] 代表从i到j是否是回文串
     *
     *  dp[i][j] = {dp[i-1][j-1] && (s.charAt[i] == s.charAt[j]}
     *
     *  for循环的时候外层循环用gap，gap就是j-i的值
     *
     *
     *
     */
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

    /*************/


    public static void main(String[] args){
//        Solution_5 temp = new Solution_5();
//        System.out.println(temp.longestPalindrome("abba"));

    }


}
