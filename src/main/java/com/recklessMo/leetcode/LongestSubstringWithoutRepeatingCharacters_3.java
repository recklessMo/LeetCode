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

}
