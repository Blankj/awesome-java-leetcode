package com.blankj.easy._100;


import com.blankj.structure.TreeNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/08
 *     desc  :
 * </pre>
 */
public class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) return p == q;
        if (p.val != q.val) return false;
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isSameTree(
                TreeNode.createTestData("[1,2,2,null,3,null,3]"),
                TreeNode.createTestData("[1,2,2,null,3,null,3]"))
        );
        System.out.println(solution.isSameTree(
                TreeNode.createTestData("[1,2,2,null,3,null,3]"),
                TreeNode.createTestData("[1,2,2,null,3,null,null]"))
        );
    }
}
