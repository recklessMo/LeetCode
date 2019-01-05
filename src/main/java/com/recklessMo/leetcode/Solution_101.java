package com.recklessMo.leetcode;


import apple.laf.JRSUIUtils;
import com.recklessMo.leetcode.model.TreeNode;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;

public class Solution_101 {


    public boolean isSymmetric(TreeNode root) {

        if(root == null){
            return true;
        }

        return helper(root.left, root.right);

    }

    private boolean helper(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        if(left.val != right.val){
            return false;
        }

        return helper(left.right, right.left) && helper(left.left, right.right);
    }



    public static void main(String[] args) {

        Solution_101 test = new Solution_101();


    }


}
