package com.blankj.easy._112;


import com.blankj.structure.TreeNode;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/11
 *     desc  :
 * </pre>
 */
public class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        if (root == null) return false;
        if (root.left == null && root.right == null) return sum == root.val;
        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode testData = TreeNode.createTestData("[5,4,8,11,null,13,4,7,2,null,null,null,1]");
        TreeNode.print(testData);
        System.out.println(solution.hasPathSum(testData, 22));
    }
}
