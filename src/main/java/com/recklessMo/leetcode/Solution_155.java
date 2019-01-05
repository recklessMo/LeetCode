package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.ListNode;

import java.util.Stack;

public class Solution_155 {

    private Stack<Integer> data = null;
    private Stack<Integer> min = null;

    /** initialize your data structure here. */
    public Solution_155() {
        data = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    public void push(int x) {
        data.push(x);
        if(min.size() == 0){
            min.push(x);
        }else{
            int top = min.peek();
            min.push(top < x ? top : x);
        }
    }

    public void pop() {
        data.pop();
        min.pop();
    }

    public int top() {
        return data.peek();
    }

    public int getMin() {
        return min.peek();
    }

    public static void main(String[] args){
        Solution_155 temp = new Solution_155();

    }


}
