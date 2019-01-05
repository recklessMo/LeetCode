package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

import java.util.Stack;

public class Solution_538 {


    private int current = 0;

    public TreeNode convertBST(TreeNode root) {

        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur =  root;
        int sum = 0;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.right;
            }else{
                cur = stack.peek();
                cur.val = cur.val + sum;
                sum = cur.val;

                cur = cur.left;
                stack.pop();
            }
        }
        return root;
    }

    public TreeNode convertBST1(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode right = convertBST(root.right);
        current += root.val;
        TreeNode total = new TreeNode(current);
        total.right = right;
        total.left = convertBST(root.left);
        return total;
    }




    public static void main(String[] args){
        Solution_538 temp = new Solution_538();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

//        int a  = 2^2^2^45;

        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(13);


        temp.convertBST(root);


    }


}
