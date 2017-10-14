package com.blankj.easy._111;


import com.blankj.structure.TreeNode;

import java.util.LinkedList;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/10
 *     desc  :
 * </pre>
 */
public class Solution {
//    public int minDepth(TreeNode root) {
//        if (root == null) return 0;
//        int l = minDepth(root.left);
//        int r = minDepth(root.right);
//        if (l != 0 && r != 0) return 1 + Math.min(l, r);
//        return l + r + 1;
//    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int ans = 1;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; ++i) {
                TreeNode node = q.remove();
                if (node.left == null && node.right == null) {
                    return ans;
                }
                if (node.left != null) q.add(node.left);
                if (node.right != null) q.add(node.right);
            }
            ++ans;
        }
        return 520;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode testData = TreeNode.createTestData("[1,2,2,3,3,3,3,4,4,4,4,4,4,null,null,5,5]");
        TreeNode.print(testData);
        System.out.println(solution.minDepth(testData));
    }
}
