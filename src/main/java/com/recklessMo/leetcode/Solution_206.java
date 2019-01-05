package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.ListNode;

public class Solution_206 {


    public ListNode reverseList(ListNode head) {
        ListNode newHead = null;
        ListNode current = head;
        while(current != null){
            ListNode next = current.next;
            current.next = newHead;
            newHead = current;
            current = next;
        }
        return newHead;
    }

    public ListNode reverseList1(ListNode head) {
        if(head == null){
            return null;
        }
        if(head.next == null){
            return head;
        }

        ListNode last = head.next;
        ListNode newHead = reverseList(head.next);
        last.next = head;
        head.next = null;
        return newHead;
    }

    public static void main(String[] args){
        Solution_206 temp = new Solution_206();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
