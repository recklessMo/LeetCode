package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;

import java.util.Stack;

public class Solution_21 {


    /**
     * digui jiefa
     * @param l1
     * @param l2
     * @return
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null || l2 == null){
            return (l1 == null ? l2 : l1);
        }else{
            if(l1.val < l2.val) {
                l1.next = mergeTwoLists(l1.next, l2);
                return l1;
            }else{
                l2.next = mergeTwoLists(l1, l2.next);
                return l2;
            }
        }
    }


    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode head = dummy;
        while(l1 != null && l2 != null){
            ListNode temp = new ListNode(0);
            if(l1.val < l2.val){
                temp.val = l1.val;
                l1 = l1.next;
            }else{
                temp.val = l2.val;
                l2 = l2.next;
            }
            head.next = temp;
            head = temp;
        }
        if(l1 != null){
            head.next = l1;
        } else if(l2 != null){
            head.next = l2;
        }
        return dummy.next;
    }

}
