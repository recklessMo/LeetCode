package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

public class Solution_572 {


    public boolean isSubtree(TreeNode s, TreeNode t) {
        if(isSameTree(s, t)){
            return true;
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    public boolean isSameTree(TreeNode left, TreeNode right){
        if(left == null && right == null){
            return true;
        }
        if(left == null || right == null){
            return false;
        }

        return left.val == right.val && isSameTree(left.left, right.left) && isSameTree(left.right, right.right);
    }

    public static void main(String[] args){
        Solution_572 temp = new Solution_572();

    }


}
