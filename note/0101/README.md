# [Symmetric Tree][title]

## Description

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree `[1,2,2,3,4,4,3]` is symmetric:

```
    1
   / \
  2   2
 / \ / \
3  4 4  3
```

But the following `[1,2,2,null,3,null,3]` is not:

```
    1
   / \
  2   2
   \   \
   3    3
```

**Note:**

Bonus points if you could solve it both recursively and iteratively.

**Tags:** Tree, Depth-first Search, Breadth-first Search


## 思路 0

题意是判断一棵二叉树是否左右对称，首先想到的是深搜，比较根结点的左右两棵子树是否对称，如果左右子树的值相同，那么再分别对左子树的左节点和右子树的右节点，左子树的右节点和右子树的左节点做比较即可。

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
    public boolean isSymmetric(TreeNode root) {
        return root == null || helper(root.left, root.right);
    }

    public boolean helper(TreeNode left, TreeNode right) {
        if (left == null || right == null) return left == right;
        if (left.val != right.val) return false;
        return helper(left.left, right.right) && helper(left.right, right.left);
    }
}
```

## 思路 1

第二种思路就是宽搜了，宽搜肯定要用到队列，Java 中可用 `LinkedList` 替代，也是要做到左子树的左节点和右子树的右节点，左子树的右节点和右子树的左节点做比较即可。

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
     public boolean isSymmetric(TreeNode root) {
        if (root == null) return true;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root.left);
        q.add(root.right);
        TreeNode left, right;
        while (q.size() > 1) {
            left = q.pop();
            right = q.pop();
            if (left == null && right == null) continue;
            if (left == null || right == null) return false;
            if (left.val != right.val) return false;
            q.add(left.left);
            q.add(right.right);
            q.add(left.right);
            q.add(right.left);
        }
        return true;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/symmetric-tree
[ajl]: https://github.com/Blankj/awesome-java-leetcode
