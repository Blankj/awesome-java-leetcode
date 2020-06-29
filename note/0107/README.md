# [Binary Tree Level Order Traversal II][title]

## Description

Given a binary tree, return the *bottom-up level order* traversal of its nodes' values. (ie, from left to right, level by level from leaf to root).

For example:

Given binary tree `[3,9,20,null,null,15,7]`,

```
    3
   / \
  9  20
    /  \
   15   7
```

return its bottom-up level order traversal as:

```
[
  [15,7],
  [9,20],
  [3]
]
```

**Tags:** Tree, Breadth-first Search


## 思路 0

题意是从下往上按层遍历二叉树，每一层是从左到右，按层遍历，很明显，宽搜第一时间符合，因为是从下往上，所以插入的时候每次插到链表头即可。

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if (root == null) return Collections.emptyList();
        List<List<Integer>> list = new LinkedList<>();
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> sub = new LinkedList();
            for(int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                sub.add(node.val);
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            list.add(0, sub);
        }
        return list;
    }
}
```

## 思路 1

另一种思路就是深搜，深搜的时候同时记录深度，然后在相应的层插入节点值即可。

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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<>();
        helper(list, root, 0);
        return list;
    }

    private void helper(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level >= list.size()) {
            list.add(0, new LinkedList<>());
        }
        helper(list, root.left, level + 1);
        helper(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/binary-tree-level-order-traversal-ii
[ajl]: https://github.com/Blankj/awesome-java-leetcode
