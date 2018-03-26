package com.recklessMo.leetcode;

public class Solution_14 {

    public String longestCommonPrefix(String[] strs) {
        StringBuilder sb = new StringBuilder();
        if (strs == null || strs.length < 1) {
            return sb.toString();
        }
        for (int j = 0; ; j++) {
            boolean add = true;
            if (j >= strs[0].length()) {
                add = false;
            } else {
                for (int i = 1; i < strs.length; i++) {
                    if (j >= strs[i].length() || strs[i].charAt(j) != strs[i - 1].charAt(j)) {
                        add = false;
                        break;
                    }
                }
            }
            if (!add) {
                break;
            }
            sb.append(strs[0].charAt(j));
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        new Thread(new Task()).start();

        System.out.println("main done");

    }


    public static class Task implements  Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(20000);
            }catch (Exception e){

            }

            System.out.println("done");
        }
    }


}
