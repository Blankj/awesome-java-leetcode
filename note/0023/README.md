# [Merge k Sorted Lists][title]

## Description

Merge *k* sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

**Example:**

```
Input:
[
  1->4->5,
  1->3->4,
  2->6
]
Output: 1->1->2->3->4->4->5->6
```

**Tags:** Linked List, Divide and Conquer, Heap


## 思路 0

题意是合并多个已排序的链表，分析并描述其复杂度，我们可以用分治法来两两合并他们，假设 `k` 为总链表个数，`N` 为总元素个数，那么其时间复杂度为 `O(Nlogk)`。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) return null;
        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int left, int right) {
        if (left >= right) return lists[left];
        int mid = left + right >>> 1;
        ListNode l0 = helper(lists, left, mid);
        ListNode l1 = helper(lists, mid + 1, right);
        return merge2Lists(l0, l1);
    }

    private ListNode merge2Lists(ListNode l0, ListNode l1) {
        ListNode node = new ListNode(0), tmp = node;
        while (l0 != null && l1 != null) {
            if (l0.val <= l1.val) {
                tmp.next = new ListNode(l0.val);
                l0 = l0.next;
            } else {
                tmp.next = new ListNode(l1.val);
                l1 = l1.next;
            }
            tmp = tmp.next;
        }
        tmp.next = l0 != null ? l0 : l1;
        return node.next;
    }
}
```

## 思路 1

还有另一种思路是利用优先队列，该数据结构用到的是堆排序，所以对总链表个数为 `k` 的复杂度为 `logk`，总元素为个数为 `N` 的话，其时间复杂度也为 `O(Nlogk)`。

```java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/merge-k-sorted-lists
[ajl]: https://github.com/Blankj/awesome-java-leetcode
