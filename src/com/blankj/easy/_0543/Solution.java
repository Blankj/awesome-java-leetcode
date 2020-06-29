package com.blankj.easy._543;


import com.blankj.structure.TreeNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/13
 *     desc  :
 * </pre>
 */
public class Solution {
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        helper(root);
        return max;
    }

    private int helper(TreeNode root) {
        if (root == null) return 0;
        int l = helper(root.left);
        int r = helper(root.right);
        if (l + r > max) max = l + r;
        return Math.max(l, r) + 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.diameterOfBinaryTree(TreeNode.createTestData("[1,2,3,4,5]")));
    }
}
