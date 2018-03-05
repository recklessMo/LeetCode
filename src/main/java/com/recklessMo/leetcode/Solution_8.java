package com.recklessMo.leetcode;

public class Solution_8 {

    public int myAtoi(String str) {
        //empty
        if(str == null || str.length() == 0){
            return 0;
        }

        //remove spaces
        int index = 0;
        int len = str.length();
        while(index < len && str.charAt(index) == ' '){
            index++;
        }

        //judge the op
        int sign = 1;
        if(str.charAt(index) == '+' || str.charAt(index) == '-'){
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }

        //begin with number;
        int sum = 0;
        while(index < len){
            int digit = str.charAt(index) - '0';
            if(digit >= 0 && digit <= 9){
                if((Integer.MAX_VALUE - digit)/10 < sum ){
                    return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
                }
                sum = sum * 10 + digit;
                index++;
            }else{
                return sum * sign;
            }
        }
        return sum * sign;
    }


    public static void main(String[] args){
        System.out.println(new Solution_8().myAtoi("-2147483647"));
    }

}
