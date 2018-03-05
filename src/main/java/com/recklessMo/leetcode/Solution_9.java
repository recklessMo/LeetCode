package com.recklessMo.leetcode;

public class Solution_9 {

    public boolean isPalindrome(int x) {
        if(x < 0 || (x != 0 && x % 10 == 0)) return false;
        int sum = 0;
        while(x > sum){
            sum = sum * 10 + x % 10;
            x /= 10;
        }
        return x == sum || sum / 10 == x;
    }


    //compare half of the digit, so no overflow need to concern

}
