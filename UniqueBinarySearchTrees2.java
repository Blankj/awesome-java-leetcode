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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) return new LinkedList<TreeNode>();
        return generateSubtrees(1, n);
    }
    
    public List<TreeNode> generateSubtrees(int s, int e) {
        List<TreeNode> res = new LinkedList<>();
        if(s > e) {
            res.add(null);
            return res;
        }
        for(int i = s; i <= e; i++) {
            List<TreeNode> left = generateSubtrees(s, i-1);
            List<TreeNode> right = generateSubtrees(i+1, e);
            for(TreeNode l: left) {
                for(TreeNode r: right) {
                    TreeNode n = new TreeNode(i);
                    n.left = l;
                    n.right = r;
                    res.add(n);
                }
            }
        }
        return res;
    }
}
