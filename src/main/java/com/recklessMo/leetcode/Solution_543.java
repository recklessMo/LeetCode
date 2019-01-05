package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_543 {


    private int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root){
        if(root == null){
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        int sum = left + right;
        if(sum > max){
            max = sum;
        }
        return Math.max(left, right) + 1;
    }


    public static void main(String[] args) {

        Solution_543 test = new Solution_543();
        int[] nums = new int[]{0, 0};


    }


}
