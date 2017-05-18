package com.blankj.easy._083;

import com.blankj.structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/10
 *     desc  :
 * </pre>
 */

public class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head;
        while (curr.next != null) {
            if (curr.next.val == curr.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.deleteDuplicates(ListNode.createTestData(new int[]{1, 1, 2})));
        System.out.println(solution.deleteDuplicates(ListNode.createTestData(new int[]{1, 1, 2, 3, 3})));
    }
}
