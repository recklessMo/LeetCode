package com.recklessMo.leetcode;


import com.recklessMo.leetcode.model.ListNode;

import java.util.HashMap;

public class Solution_160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        ListNode first = headA;
        ListNode second = headB;

        int lenA = 0;
        int lenB = 0;

        while(first != null && first.next != null){
            first = first.next;
            lenA++;
        }

        while(second != null && second.next != null){
            second = second.next;
            lenB++;
        }


        if(first == second){
            //证明有交点

            ListNode startA = headA;
            ListNode startB = headB;

            if(lenA > lenB){
                for(int i = 0; i < lenA - lenB; i++){
                    startA = startA.next;
                }
            }else if(lenA < lenB){
                for(int i = 0; i < lenB - lenA; i++){
                    startB = startB.next;
                }
            }

            while(startA != startB){
                startA = startA.next;
                startB = startB.next;
            }

            return startA;
        }

        return null;

    }


    public static void main(String[] args){
        Solution_160 temp = new Solution_160();

    }


}
