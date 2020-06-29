package com.blankj.medium._005;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/11/04
 *     desc  :
 * </pre>
 */
public class Solution {
//    int st, end;
//
//    public String longestPalindrome(String s) {
////        st = 0;
////        end = 0;
//        int len = s.length();
//        if (len <= 1) return s;
//        char[] chars = s.toCharArray();
//        for (int i = 0; i < len; i++) {
//            helper(chars, i, i);
//            helper(chars, i, i + 1);
//        }
//        return s.substring(st, end + 1);
//    }
//
//    private void helper(char[] chars, int l, int r) {
//        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
//            --l;
//            ++r;
//        }
//        if (end - st < r - l - 2) {
//            st = l + 1;
//            end = r - 1;
//        }
//    }

//    public String longestPalindrome(String s) {
//        int len = s.length();
//        if (len <= 1) return s;
//        int st = 0, end = 0;
//        char[] chars = s.toCharArray();
//        boolean[][] dp = new boolean[len][len];
//        for (int i = 0; i < len; i++) {
//            dp[i][i] = true;
//            for (int j = 0; j < i; j++) {
//                if (j + 1 == i) {
//                    dp[j][i] = chars[j] == chars[i];
//                } else {
//                    dp[j][i] = dp[j + 1][i - 1] && chars[j] == chars[i];
//                }
//                if (dp[j][i] && i - j > end - st) {
//                    st = j;
//                    end = i;
//                }
//            }
//        }
//        return s.substring(st, end + 1);
//    }

    public String longestPalindrome(String s) {

        return s;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));

    }
}
