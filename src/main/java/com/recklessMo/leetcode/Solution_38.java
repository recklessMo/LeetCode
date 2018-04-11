package com.recklessMo.leetcode;


public class Solution_38 {

    public String countAndSay(int n) {
        if(n == 0) return "";
        String result = "1";
        for(int i = 2; i <= n; i++){
            result = produce(result);
        }
        return result;
    }

    private String produce(String result){
        StringBuilder sb = new StringBuilder();
        int count = 1;
        Character c = result.charAt(0);
        for(int i = 1; i < result.length(); i++){
            if(result.charAt(i) == c){
                count++;
            }else{
                sb.append(count);
                sb.append(c);
                c = result.charAt(i);
                count = 1;
            }
        }
        sb.append(count);
        sb.append(c);
        return sb.toString();
    }

    public static void main(String[] args){

    }


}
