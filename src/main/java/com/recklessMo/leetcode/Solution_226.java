package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.TreeNode;

import java.util.Stack;

public class Solution_226 {


    /**
     *
     *  尝试一下非递归，和后序遍历比较像
     *
     * @param root
     * @return
     */
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return null;
        }
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        TreeNode last = null;
        while(cur != null || !stack.isEmpty()){
            if(cur != null){
                stack.push(cur);
                cur = cur.left;
            }else {
                cur = stack.peek();
                if(cur.right == null || last == cur.right){
                    //follow the post order
                    //do the logic here，eg swap the left & right node ,or output the node
                    TreeNode temp = cur.left;
                    cur.left = cur.right;
                    cur.right = temp;

                    last = cur;
                    stack.pop();
                    cur = null;
                }else{
                    cur = cur.right;
                }
            }
        }
        return root;
    }


    /**
     *
     * 受限于栈深度
     *
     * @param root
     * @return
     */
    public TreeNode invertTree1(TreeNode root) {
        if(root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = invertTree(right);
        root.right = invertTree(left);
        return root;
    }



    public static void main(String[] args){
        Solution_226 temp = new Solution_226();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
