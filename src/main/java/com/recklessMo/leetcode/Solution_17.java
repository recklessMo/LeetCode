package com.recklessMo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_17 {

    private String[] posMap = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

    public List<String> letterCombinations(String digits) {
        int len = digits.length();
        List<String> result = new LinkedList<>();
        search(result, new StringBuilder(), 0, len, digits);
        return result;
    }

    private void search(List<String> result, StringBuilder sb, int pos, int len, String digits){
        if(pos == len){
            if(len != 0){
                result.add(sb.toString());
            }
            return;
        }
        char x = digits.charAt(pos);
        int num = x - '0';
        for(int i = 0; i < posMap[num].length(); i++){
            sb.append(posMap[num].charAt(i));
            search(result, sb, pos + 1, len, digits);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

}
