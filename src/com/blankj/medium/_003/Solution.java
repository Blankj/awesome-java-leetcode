package com.blankj.medium._003;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/11
 *     desc  :
 * </pre>
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int l = i - preP + 1;
            hash[c] = i + 1;
            if (l > max) max = l;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        System.out.println(solution.lengthOfLongestSubstring("Abcabcbb"));
    }
}
