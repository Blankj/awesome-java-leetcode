package com.blankj.easy._014;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/26
 *     desc  :
 * </pre>
 */
public class Solution {
    public String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if (len == 0) return "";
        int minLen = 0x7fffffff;
        for (String str : strs) minLen = Math.min(minLen, str.length());
        for (int j = 0; j < minLen; ++j)
            for (int i = 1; i < len; ++i)
                if (strs[0].charAt(j) != strs[i].charAt(j))
                    return strs[0].substring(0, j);
        return strs[0].substring(0, minLen);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestCommonPrefix(new String[]{"abc", "abcd", "ab"}));
    }
}
