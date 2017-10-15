package com.blankj.hard._023;

import com.blankj.structure.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/15
 *     desc  :
 * </pre>
 */
public class Solution {
//    public ListNode mergeKLists(ListNode[] lists) {
//        if (lists.length == 0) return null;
//        return helper(lists, 0, lists.length - 1);
//    }
//
//    private ListNode helper(ListNode[] lists, int left, int right) {
//        if (left >= right) return lists[left];
//        int mid = left + right >>> 1;
//        ListNode l0 = helper(lists, left, mid);
//        ListNode l1 = helper(lists, mid + 1, right);
//        return merge2Lists(l0, l1);
//    }
//
//    private ListNode merge2Lists(ListNode l0, ListNode l1) {
//        ListNode node = new ListNode(0), tmp = node;
//        while (l0 != null && l1 != null) {
//            if (l0.val <= l1.val) {
//                tmp.next = new ListNode(l0.val);
//                l0 = l0.next;
//            } else {
//                tmp.next = new ListNode(l1.val);
//                l1 = l1.next;
//            }
//            tmp = tmp.next;
//        }
//        tmp.next = l0 != null ? l0 : l1;
//        return node.next;
//    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode o1, ListNode o2) {
                if (o1.val < o2.val) return -1;
                else if (o1.val == o2.val) return 0;
                else return 1;
            }
        });
        ListNode node = new ListNode(0), tmp = node;
        for (ListNode l : lists) {
            if (l != null) queue.add(l);
        }
        while (!queue.isEmpty()) {
            tmp.next = queue.poll();
            tmp = tmp.next;
            if (tmp.next != null) queue.add(tmp.next);
        }
        return node.next;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.mergeKLists(new ListNode[]{
                ListNode.createTestData("[1,3,5,7]"),
                ListNode.createTestData("[2,4,6]")
        }));
    }
}
