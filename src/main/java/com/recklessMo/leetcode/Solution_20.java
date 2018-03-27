package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;

import java.util.Stack;

public class Solution_20 {

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++) {
            Character temp = s.charAt(i);
            if (temp.equals('{')){
                stack.push('}');
            }else if(temp.equals('(')){
                stack.push(')');
            }else if(temp.equals('[')) {
                stack.push(']');
            }else if(stack.isEmpty() || stack.pop() != temp){
                return false;
            }
        }
        return stack.isEmpty();
    }

}
