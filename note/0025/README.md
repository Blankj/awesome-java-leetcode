# [Reverse Nodes in k-Group][title]

## Description

Given a linked list, reverse the nodes of a linked list *k* at a time and return its modified list.

*k* is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of *k* then left-out nodes in the end should remain as it is.


**Example:**

Given this linked list: `1->2->3->4->5`

For *k* = 2, you should return: `2->1->4->3->5`

For *k* = 3, you should return: `3->2->1->4->5`

**Note:**

- Only constant extra memory is allowed.
- You may not alter the values in the list's nodes, only nodes itself may be changed.

**Tags:** Linked List


## 思路

题意是让你以 `k` 个元素为一组来翻转链表，最后不足 `k` 个的话不需要翻转，最传统的思路就是每遇到 `k` 个元素，对其 `k` 个元素进行翻转，而难点就是在此，下面介绍其原理，我们以例子中的 `k = 3` 为例，其 `pre` 和 `next` 如下所示。

```
0->1->2->3->4->5
|           |
pre        next
```

我们要做的就是把 `pre` 和 `next` 之间的元素逆序，思想是依次从第二个元素到第 `k` 个元素，依次把它插入到 `pre` 后面，过程如下。

```
 head move
   |  |
0->1->2->3->4->5
|           |
pre        next

    head move
      |  |
0->2->1->3->4->5
|           |
pre        next

       head move
         |  |
0->3->2->1->4->5
|           |
pre        next
```

好了，根据原理，那写出代码就不难了。

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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/reverse-nodes-in-k-group
[ajl]: https://github.com/Blankj/awesome-java-leetcode
