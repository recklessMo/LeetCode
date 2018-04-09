package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;


public class Solution_23 {


    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(0);
        Queue<ListNode> queue = new PriorityQueue<>(new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                return o1.val - o2.val;
            }
        });
        for(ListNode temp : lists){
            if(temp != null) {
                queue.add(temp);
            }
        }
        ListNode head = dummy;
        while(!queue.isEmpty()){
            ListNode temp = queue.poll();
            if(temp.next != null){
                queue.add(temp.next);
            }
            head.next = temp;
            head = temp;
        }
        return dummy.next;
    }


    public static void main(String[] args){

    }


}
