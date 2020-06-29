# [Convert Sorted Array to Binary Search Tree][title]

## Description

Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of *every* node never differ by more than 1.

**Example:**

```
Given the sorted array: [-10,-3,0,5,9],

One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

      0
     / \
   -3   9
   /   /
 -10  5
```

**Tags:** Tree, Depth-first Search


## 思路

题意是把一个有序数组转化为一棵二叉搜索树，二叉搜索树具有以下性质：

1. 若任意节点的左子树不空，则左子树上所有节点的值均小于它的根节点的值；

2. 若任意节点的右子树不空，则右子树上所有节点的值均大于它的根节点的值；

3. 任意节点的左、右子树也分别为二叉查找树；

4. 没有键值相等的节点。

所以我们可以用递归来构建一棵二叉搜索树，每次把数组分为两半，把数组中间的值作为其父节点，然后把数组的左右两部分继续构造其左右子树。


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
    public TreeNode sortedArrayToBST(int[] nums) {
        if (nums == null || nums.length == 0) return null;
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (left + right) >>> 1;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums, left, mid - 1);
        node.right = helper(nums, mid + 1, right);
        return node;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/convert-sorted-array-to-binary-search-tree
[ajl]: https://github.com/Blankj/awesome-java-leetcode
