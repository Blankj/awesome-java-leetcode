package com.blankj.hard._1028;

import com.blankj.structure.TreeNode;

import java.util.LinkedList;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2020/06/19
 *     desc  :
 * </pre>
 */
public class Solution {
//    public TreeNode recoverFromPreorder(String S) {
//        char[] chars = S.toCharArray();
//        int len = chars.length;
//        List<TreeNode> levels = new LinkedList<>();
//        for (int i = 0; i < len; ) {
//            int level = 0, val = 0;
//            while (chars[i] == '-') { // 获取所在层级，Character.isDigit() 会比较慢
//                ++i;
//                ++level;
//            }
//            while (i < len && chars[i] != '-') { // 获取节点的值
//                val = val * 10 + chars[i++] - '0';
//            }
//            TreeNode curNode = new TreeNode(val);
//            if (level > 0) {
//                TreeNode parent = levels.get(level - 1);
//                if (parent.left == null) { // 如果节点只有一个子节点，那么保证该子节点为左子节点。
//                    parent.left = curNode;
//                } else {
//                    parent.right = curNode;
//                }
//            }
//            levels.add(level, curNode); // 因为是前序遍历（根-左-右），也就是右覆盖左时，此时左树已遍历完成，故无需考虑覆盖问题
//        }
//        return levels.get(0);
//    }

    public TreeNode recoverFromPreorder(String S) {
        char[] chars = S.toCharArray();
        int len = chars.length;
        LinkedList<TreeNode> stack = new LinkedList<>();
        for (int i = 0; i < len; ) {
            int level = 0, val = 0;
            while (chars[i] == '-') { // 获取所在层级，Character.isDigit() 会比较慢
                ++i;
                ++level;
            }
            while (i < len && chars[i] != '-') { // 获取节点的值
                val = val * 10 + chars[i++] - '0';
            }
            TreeNode curNode = new TreeNode(val);
            while (stack.size() > level) { // 栈顶不是父亲，栈顶出栈
                stack.removeLast();
            }
            if (level > 0) {
                TreeNode parent = stack.getLast();
                if (parent.left == null) { // 如果节点只有一个子节点，那么保证该子节点为左子节点。
                    parent.left = curNode;
                } else {
                    parent.right = curNode;
                }
            }
            stack.addLast(curNode);
        }
        return stack.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        TreeNode.print(solution.recoverFromPreorder("1-2--3--4-5--6--7"));
        System.out.println("==============================================");
        TreeNode.print(solution.recoverFromPreorder("1-2--3---4-5--6---7"));
    }
}
