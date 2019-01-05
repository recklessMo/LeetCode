package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.ListNode;

public class Solution_141 {


    public boolean hasCycle(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode fast = dummy;
        ListNode slow = dummy;

        while(fast != null){
            if(fast.next == null){
                break;
            }
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                return true;
            }
        }
        return false;
    }


    public static void main(String[] args){
        Solution_141 temp = new Solution_141();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        System.out.println(a);
    }


}
