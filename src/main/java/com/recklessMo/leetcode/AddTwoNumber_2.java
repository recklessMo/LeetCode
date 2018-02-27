package com.recklessMo.leetcode;

import com.recklessMo.leetcode.model.ListNode;

public class AddTwoNumber_2 {

    /**
     *
     * 对于这种，要注意空指针，截止条件是 加数不为null或者进位不为0
     *
     * @param l1
     * @param l2
     * @return
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode pos = head;
        int carry = 0;
        while(l1 != null || l2 != null || carry != 0) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;
            int num = a + b + carry;
            pos.next = new ListNode(num % 10);
            pos = pos.next;
            carry = num / 10;
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        return head.next;
    }

}
