package com.blankj.medium._024;

import com.blankj.structure.ListNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/31
 *     desc  :
 * </pre>
 */
public class Solution {
//    public ListNode swapPairs(ListNode head) {
//        if (head == null || head.next == null) return head;
//        ListNode node = head.next;
//        head.next = swapPairs(node.next);
//        node.next = head;
//        return node;
//    }

    public ListNode swapPairs(ListNode head) {
        ListNode preHead = new ListNode(0), cur = preHead;
        preHead.next = head;
        while (cur.next != null && cur.next.next != null) {
            ListNode temp = cur.next.next;
            cur.next.next = temp.next;
            temp.next = cur.next;
            cur.next = temp;
            cur = cur.next.next;
        }
        return preHead.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.swapPairs(ListNode.createTestData("[1,2,3,4]")));
    }
}
