package com.recklessMo.leetcode;

public class Solution_11 {

    public int maxArea(int[] height) {
        int len = height.length;
        int left = 0;
        int right = len - 1;
        int max = 0;
        while(left < right){
            int value = (right - left) * Math.min(height[left], height[right]);
            if(value > max){
                max = value;
            }
            if(height[left] <= height[right]){
                int start = left + 1;
                while(start < len && height[start] <= height[left]){
                    start++;
                }
                left = start;
            }else{
                int end = right - 1;
                while(end > 0 && height[end] <= height[right]){
                    end--;
                }
                right = end;
            }
        }
        return max;
    }


    public static void main(String[] args){
        //先确定穷举的复杂度平方

        //然后采用双指针的方式，进行遍历
        //如果i,j构成一个container， 如果height[i] < height[j], 那么需要把i往右边移动，找到第一个比height[i]大的数才有意义。
        //否则如果比height[i]小的话，那是不会比height[i]更优的，j也是同样的道理


    }


}
