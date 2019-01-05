package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.TreeNode;

public class Solution_617 {


    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null){
            return null;
        }
        int left = t1 == null ? 0 : t1.val;
        int right = t2 == null ? 0 : t2.val;
        TreeNode root = new TreeNode(left + right);
        if(t1 == null){
            root.left = mergeTrees(null, t2.left);
            root.right = mergeTrees(null, t2.right);
        }else if(t2 == null){
            root.left = mergeTrees(t1.left, null);
            root.right = mergeTrees(t1.right, null);
        }else{
            root.left = mergeTrees(t1.left, t2.left);
            root.right = mergeTrees(t1.right, t2.right);
        }
        return root;
    }

    public static void main(String[] args) {

        Solution_617 test = new Solution_617();

    }


}
