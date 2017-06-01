package com.blankj.easy._020;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/28
 *     desc  :
 * </pre>
 */

public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char[] stack = new char[len + 1];
        int top = 1;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack[top++] = c;
            else if (c == ')' && stack[top - 1] != '(')
                return false;
            else if (c == ']' && stack[top - 1] != '[')
                return false;
            else if (c == '}' && stack[top - 1] != '{')
                return false;
            else
                --top;
        }
        return top == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}({[]})"));
        System.out.println(solution.isValid("(])]"));
    }
}
