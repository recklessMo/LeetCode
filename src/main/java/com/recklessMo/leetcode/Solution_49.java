package com.recklessMo.leetcode;


import org.apache.commons.codec.binary.StringUtils;

import java.util.*;

public class Solution_49 {


    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        Map<String, Integer> keyMap = new HashMap<>();
        int index = 0;
        for(String str : strs){
            char[] temp = str.toCharArray();
            Arrays.sort(temp);
            String tempStr = new String(temp);
            Integer pos = keyMap.get(tempStr);
            if(pos == null){
                List<String> tempList = new ArrayList<>();
                tempList.add(str);
                result.add(tempList);
                keyMap.put(tempStr, index++);
            }else{
                result.get(pos).add(str);
            }
        }
        return result;
    }


    public static void main(String[] args){
    }


}
