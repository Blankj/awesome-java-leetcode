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
        char[] stack = new char[s.length() + 1];
        int top = 1;
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '[' || c == '{') {
                stack[top++] = c;
            } else if (c == ')' && stack[--top] != '(') {
                return false;
            } else if (c == ']' && stack[--top] != '[') {
                return false;
            } else if (c == '}' && stack[--top] != '{') {
                return false;
            }
        }
        return top == 1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()[]{}({[]})"));
        System.out.println(solution.isValid("(])]"));
    }
}
