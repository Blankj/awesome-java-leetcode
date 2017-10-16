package com.blankj.hard._025;

import com.blankj.structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/16
 *     desc  :
 * </pre>
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) return head;
        ListNode node = new ListNode(0), pre = node;
        node.next = head;
        for (int i = 1; head != null; ++i) {
            if (i % k == 0) {
                pre = reverse(pre, head.next);
                head = pre.next;
            } else {
                head = head.next;
            }
        }
        return node.next;
    }

    private ListNode reverse(ListNode pre, ListNode next) {
        ListNode head = pre.next;
        ListNode move = head.next;
        while (move != next) {
            head.next = move.next;
            move.next = pre.next;
            pre.next = move;
            move = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.reverseKGroup(ListNode.createTestData("[1,2,3,4,5,6,7,8]"), 3));
    }
}
