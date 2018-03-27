package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;

import java.util.LinkedList;
import java.util.List;

public class Solution_19 {

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        int i = 0;
        while(i++ <= n){
            fast = fast.next;
        }

        while(fast != null){
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }

}
