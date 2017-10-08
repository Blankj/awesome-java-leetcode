package com.blankj.medium._019;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/27
 *     desc  :
 * </pre>
 */
public class Solution {

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }

        @Override
        public String toString() {
            String str = "[" + String.valueOf(val);
            ListNode p = next;
            while (p != null) {
                str += ", " + String.valueOf(p.val);
                p = p.next;
            }
            return str + "]";
        }
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode pre = head;
        ListNode afterPreN = head;
        while (n-- != 0) {
            afterPreN = afterPreN.next;
        }
        if (afterPreN != null) {
            while (afterPreN.next != null) {
                pre = pre.next;
                afterPreN = afterPreN.next;
            }
            pre.next = pre.next.next;
        } else {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode listNode0 = new ListNode(1);
        ListNode listNode1 = new ListNode(2);
        ListNode listNode2 = new ListNode(3);
        ListNode listNode3 = new ListNode(4);
        ListNode listNode4 = new ListNode(5);
        listNode0.next = listNode1;
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = null;
        System.out.println(listNode0.toString());
        System.out.println(solution.removeNthFromEnd(listNode0, 2).toString());

        ListNode listNode5 = new ListNode(1);
        System.out.println(listNode5.toString());
        ListNode res = solution.removeNthFromEnd(listNode5, 1);
        System.out.println(res == null ? "[]" : res.toString());
    }
}