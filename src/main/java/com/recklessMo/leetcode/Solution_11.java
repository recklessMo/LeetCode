package com.recklessMo.leetcode;

import javax.swing.plaf.synth.SynthScrollBarUI;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

//        System.out.println(new Solution_11().test());
//
//        List<Integer>[] genericArray = (List<Integer>[])new ArrayList[10];
//        genericArray[0] = new ArrayList(Arrays.asList(new String[]{"1"}));


//        Integer i1 = Integer.valueOf(2);
//        Integer i2 = Integer.valueOf(2);
//        System.out.println(i1 == i2);

//        Boolean b1 = new Boolean(true);
//        Boolean b2 = new Boolean(true);
//        System.out.println(Boolean.valueOf(b1 == b2));

//        String s1 = new String("xx");
//        String s2 = new String("xx");
//        String s3 = new String(s1);
//        String s4 = String.valueOf("xx");
//        String s5 = "xx";
//
//
//        System.out.println(s4 == s5);

//        new Solution_11().add(1,2,3,4);


//        List<? extends  Number> ints = new ArrayList<Double>();
//        ints.add(null);

    }



    public <T> void add(T... varvars){
        System.out.println("test");
        return;
    }

    public int test(){

        try{
            int a = 4 / 1;
            System.out.println("try");
            return 1;
        }catch (Exception e){
            System.out.println("catch");
            return 2;
        }finally {
            System.out.println("finally");
//            return 3;
        }


    }


}
