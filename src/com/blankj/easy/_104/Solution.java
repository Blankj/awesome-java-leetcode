package com.blankj.easy._104;


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
    public int maxDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxDepth(TreeNode.createTestData("[]")));
        System.out.println(solution.maxDepth(TreeNode.createTestData("[1,2,2,3,4,4,3]")));
        System.out.println(solution.maxDepth(TreeNode.createTestData("[9,-42,-42,null,76,76,null,null,13,null,13]")));
    }
}
