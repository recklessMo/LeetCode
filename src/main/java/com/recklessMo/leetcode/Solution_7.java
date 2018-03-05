package com.recklessMo.leetcode;

public class Solution_7 {

    public int reverse(int x) {
        int sum = 0;
        while(x != 0){
            int mod = x % 10;
            int newResult = sum * 10 + mod;
            if((newResult - mod)/10 != sum){//if overflow happens, the check will fail. so return 0;
                return 0;
            }
            sum = newResult;
            x /= 10;
        }
        return sum;
    }

    public static void main(String[] args){
//        new Solution_7().reverse(111222);
        //java采用的是除法取整。
        //-3 % 10 实际上等于 -3 - （-3 / 10 * 10） = -3
        //所以理解取模需要根据除法来理解，除法有很多种的形式，所以取模也有很多形式~
//        System.out.println(-3%10);

//        Long a = new Long(123333);
//        Long b = new Long(123333);
//        long c = 123333;
//        System.out.println(a.equals(b));


        System.out.println(-123 % 10);

    }





}
