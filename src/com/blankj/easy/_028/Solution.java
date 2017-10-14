package com.blankj.easy._028;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/01
 *     desc  :
 * </pre>
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length(), l3 = l1 - l2;
        for (int i = 0; i <= l3; ++i) {
            if (haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.strStr("12345", "23"));
        System.out.println(solution.strStr("12345", ""));
    }
}
