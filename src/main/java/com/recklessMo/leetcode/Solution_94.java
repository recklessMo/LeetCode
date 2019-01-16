package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

import java.util.*;

public class Solution_94 {


    public List<Integer> inorderTraversal(TreeNode root) {

        List<Integer> resultList = new LinkedList<>();

        helper1(root, resultList);

        return resultList;
    }

    private void helper1(TreeNode root, List<Integer> dataList){
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                cur = cur.left;
            }else{
                cur = stack.peek();
                dataList.add(cur.val);
                cur = cur.right;
                stack.pop();
            }
        }
    }

    private void helper(TreeNode root, List<Integer> dataList){
        if(root == null){
            return;
        }

        helper(root.left, dataList);
        dataList.add(root.val);
        helper(root.right, dataList);
    }


    public static void main(String[] args) {

        Solution_94 test = new Solution_94();



    }


}
