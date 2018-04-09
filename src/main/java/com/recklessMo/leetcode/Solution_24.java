package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution_24 {

    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode temp = dummy;
        while(true) {
            ListNode first = temp.next;
            if (first == null) {
                break;
            }
            ListNode second = first.next;
            if(second == null){
                break;
            }
            //swap
            first.next = second.next;
            second.next = first;
            temp.next = second;
            temp = first;
        }
        return dummy.next;
    }

    public static void main(String[] args){



    }


}
