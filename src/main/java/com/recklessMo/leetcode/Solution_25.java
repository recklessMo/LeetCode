package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;


public class Solution_25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode phead = dummy;
        while(true){
            ListNode start = phead.next;
            ListNode end = phead;
            for(int i = 0; i < k; i++){
                end = end.next;
                if(end == null){
                    return dummy.next;
                }
            }
            ListNode n = end.next;
            end.next = null;
            reverse(start);
            phead.next = end;
            start.next = n;
            phead = start;
        }
    }

    public ListNode reverse(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode pre = null;
        while(temp != null){
            ListNode k = temp.next;
            temp.next = pre;
            pre = temp;
            temp = k;
        }
        return pre;
    }

    public static void main(String[] args){



    }


}
