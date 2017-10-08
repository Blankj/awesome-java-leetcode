package com.blankj.easy._021;

import com.blankj.structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/29
 *     desc  :
 * </pre>
 */
public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode temp = head;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                temp.next = l1;
                l1 = l1.next;
            } else {
                temp.next = l2;
                l2 = l2.next;
            }
            temp = temp.next;
        }
        temp.next = l1 != null ? l1 : l2;
        return head.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode00 = new ListNode(1);
        ListNode listNode01 = new ListNode(3);
        ListNode listNode02 = new ListNode(5);
        ListNode listNode03 = new ListNode(7);
        ListNode listNode04 = new ListNode(9);
        listNode00.next = listNode01;
        listNode01.next = listNode02;
        listNode02.next = listNode03;
        listNode03.next = listNode04;
        listNode04.next = null;
        ListNode listNode10 = new ListNode(2);
        ListNode listNode11 = new ListNode(4);
        ListNode listNode12 = new ListNode(6);
        ListNode listNode13 = new ListNode(8);
        ListNode listNode14 = new ListNode(10);
        listNode10.next = listNode11;
        listNode11.next = listNode12;
        listNode12.next = listNode13;
        listNode13.next = listNode14;
        listNode14.next = null;
        ListNode listNode0 = ListNode.createTestData("[1,3,5,7,9]");
        ListNode listNode1 = ListNode.createTestData("[2,4,6,8,10]");
        ListNode.print(listNode0);
        ListNode.print(listNode1);
        ListNode.print(solution.mergeTwoLists(listNode0, listNode1));
    }
}