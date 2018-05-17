# [Maximum Depth of Binary Tree][title]

## Description

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

**Note:** A leaf is a node with no children.

**Example:**

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its depth = 3.

**Tags:** Tree, Depth-first Search


## 思路

题意是找到二叉树的最大深度，很明显，深搜即可，每深入一次节点加一即可，然后取左右子树的最大深度。

```java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class Solution {
     public int maxDepth(TreeNode root) {
         if (root == null) return 0;
         return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
     }
 }
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/maximum-depth-of-binary-tree
[ajl]: https://github.com/Blankj/awesome-java-leetcode
