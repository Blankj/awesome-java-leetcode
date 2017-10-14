package com.blankj.easy._110;


import com.blankj.structure.TreeNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/09
 *     desc  :
 * </pre>
 */
public class Solution {
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }

    private int helper(TreeNode node) {
        if (node == null) return 0;
        int l = helper(node.left);
        if (l == -1) return -1;
        int r = helper(node.right);
        if (r == -1) return -1;
        if (Math.abs(l - r) > 1) return -1;
        return 1 + Math.max(l, r);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode testData = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        TreeNode.print(testData);
        System.out.println(solution.isBalanced(testData));
    }
}
