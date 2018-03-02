package com.recklessMo.leetcode;

import java.util.LinkedList;
import java.util.List;

public class Solution_6 {


    public String convert(String s, int numRows) {
        if(s == null)return null;
        List<StringBuilder> resultList = new LinkedList<>();
        for(int i = 0; i < numRows; i++){
            resultList.add(new StringBuilder());
        }
        int len = s.length();
        int next = 0;
        int gap = 0;
        for(int i = 0; i < len; i++){
            resultList.get(next).append(s.charAt(i));
            if(numRows == 1){
                gap = 0;
            }else if(next == 0){
                gap = 1;
            }else if(next == numRows - 1){
                gap = -1;
            }
            next += gap;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < resultList.size(); i++){
            sb.append(resultList.get(i)) ;
        }
        return sb.toString();
    }

}
