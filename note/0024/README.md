# [Swap Nodes in Pairs][title]

## Description

Given a linked list, swap every two adjacent nodes and return its head.

**Example:**

```
Given 1->2->3->4, you should return the list as 2->1->4->3.
```

**Note:**

- Your algorithm should use only constant extra space.
- You may **not** modify the values in the list's nodes, only nodes itself may be changed.

**Tags:** Linked List


## 思路 0

题意是让你交换链表中相邻的两个节点，最终返回交换后链表的头，限定你空间复杂度为 O(1)。我们可以用递归来算出子集合的结果，递归的终点就是指针指到链表末少于两个元素时，如果不是终点，那么我们就对其两节点进行交换，这里我们需要一个临时节点来作为交换桥梁，就不多说了。

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode node = head.next;
        head.next = swapPairs(node.next);
        node.next = head;
        return node;
    }
}
```


## 思路 1

另一种实现方式就是用循环来实现了，两两交换节点，也需要一个临时节点来作为交换桥梁，直到当前指针指到链表末少于两个元素时停止，代码很简单，如下所示。

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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/swap-nodes-in-pairs
[ajl]: https://github.com/Blankj/awesome-java-leetcode
