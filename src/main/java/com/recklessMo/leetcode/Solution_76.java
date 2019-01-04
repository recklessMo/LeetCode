package com.recklessMo.leetcode;


import java.util.*;

public class Solution_76 {

    String result = "";
    boolean first = true;

    public String minWindow(String s, String t) {
        Map<Character, Integer> targetMap = new HashMap<>();
        for(int i = 0; i < t.length(); i++){
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }

        Map<Character, Integer> dataMap = new HashMap<>();
        int start = 0;
        for(int i = 0; i < s.length(); i++){
            Character temp = s.charAt(i);
            if(targetMap.containsKey(temp)){
                dataMap.put(temp, dataMap.getOrDefault(temp, 0) + 1);
                while(ifMatch(dataMap, s, start, i + 1, targetMap)){
                    Character startChar = s.charAt(start);
                    Integer count = dataMap.get(startChar);
                    start++;
                    if(count != null && count > 1){
                        dataMap.put(startChar, count - 1);
                    }else{
                        dataMap.remove(startChar);
                    }
                }
            }
        }
        return result;
    }

    private boolean ifMatch(Map<Character, Integer> dataMap, String source, int start, int end, Map<Character, Integer> targetMap){
        if(equalMap(dataMap, targetMap)){
            String single = source.substring(start, end);
            if(single.length() < result.length() || first == true){
                result = single;
                first = false;
            }
            return true;
        }
        return false;
    }

    private boolean equalMap(Map<Character, Integer> src, Map<Character, Integer> dst){
        if(src.size() != dst.size()){
            return false;
        }
        Iterator<Map.Entry<Character, Integer>> it = dst.entrySet().iterator();
        while(it.hasNext()){
            Map.Entry<Character, Integer> single = it.next();
            Integer other = src.get(single.getKey());
            if(other == null || other < single.getValue()){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {

        Solution_76 test = new Solution_76();

        HashMap<Integer, Integer> dataMap = new HashMap<>();

        System.out.println(test.minWindow("ADOBECODEBANC", "ABC"));

        LinkedList<Integer> temp = new LinkedList<>();

        System.out.println(test.minWindow("aa", "aa"));

    }


}
