package com.recklessMo.leetcode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class Solution_22 {


    /**
     *
     *
     * 就是用搜索做的，但是做的过程中，没有关顺序，而是通过left,right来控制是否进行下一步
     *
     * 得看看有没有迭代的做法
     *
     * @param n
     * @return
     */
    public List<String> generateParenthesis(int n) {
        List<String> result = new LinkedList<>();
        search(result, new StringBuilder(), n, 0);
        return result;
    }

    private void search(List<String> result, StringBuilder sb, int left, int right){
        if(left == 0 && right == 0){
            result.add(sb.toString());
            return;
        }

        if(left > 0){
            sb.append("(");
            search(result, sb, left - 1, right + 1);
            sb.deleteCharAt(sb.length() - 1);
        }

        if(right > 0){
            sb.append(")");
            search(result, sb, left, right - 1);
            sb.deleteCharAt(sb.length() - 1);
        }

    }


    public List<String> generateParenthesisIterative(int n){
        List<List<String>> result = new LinkedList<>();
        result.add(Arrays.asList(""));
        for(int i = 1; i <= n; i++){
            List<String> temp = new LinkedList<>();
            for(int j = 0; j < i; j++){
                for(String first : result.get(j)){
                    for(String last : result.get(i - j - 1)){
                        StringBuilder sb = new StringBuilder();
                        sb.append("(");
                        sb.append(first);
                        sb.append(")");
                        sb.append(last);
                        temp.add(sb.toString());
                    }
                }

            }
            result.add(temp);
        }
        return result.get(result.size() - 1);
    }

    public static void main(String[] args){
        new Solution_22().generateParenthesis(4);
    }


}
