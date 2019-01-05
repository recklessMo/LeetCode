package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.ListNode;

public class Solution_234 {


    public boolean isPalindrome(ListNode head) {

        if(head == null || head.next == null){
            return true;
        }
        ListNode fast = head;
        ListNode slow = head;
        ListNode prevSlow = null;
        while(fast != null){
            if(fast.next == null){
                break;
            }
            fast = fast.next.next;
            prevSlow = slow;
            slow = slow.next;
        }

        //找到了中点
        ListNode first = head;
        ListNode second = null;
        if(fast == null){
            second = prevSlow.next;
            prevSlow.next = null;
        }else{
            second = slow.next;
            prevSlow.next = null;
        }

        //翻转其中一个链表
        ListNode third = reverseList(first);

        //顺序比较
        ListNode i = second;
        ListNode j = third;
        while(i != null && j != null){
            if(i.val != j.val){
                return false;
            }
            i = i.next;
            j = j.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head){
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

    public static void main(String[] args){
        Solution_234 temp = new Solution_234();

//        System.out.println(temp.singleNumber(new int[]{2,2,4,1,4}));

        int a  = 2^2^2^45;

        ListNode head = new ListNode(0);
        ListNode tail = new ListNode(0);
        head.next = tail;

        System.out.println(temp.isPalindrome(head));
    }


}
