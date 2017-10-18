package com.blankj.hard._044;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/16
 *     desc  :
 * </pre>
 */
public class Solution {
//    public boolean isMatch(String s, String p) {
//        if (p.length() == 0) return s.length() == 0;
//        int si = 0, pi = 0, match = 0, star = -1;
//        int sl = s.length(), pl = p.length();
//        char[] sc = s.toCharArray(), pc = p.toCharArray();
//        while (si < sl) {
//            if (pi < pl && (pc[pi] == sc[si] || pc[pi] == '?')) {
//                si++;
//                pi++;
//            } else if (pi < pl && pc[pi] == '*') {
//                star = pi++;
//                match = si;
//            } else if (star != -1) {
//                si = ++match;
//                pi = star + 1;
//            } else return false;
//        }
//        while (pi < pl && pc[pi] == '*') pi++;
//        return pi == pl;
//    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int sl = s.length(), pl = p.length();
        boolean[][] dp = new boolean[sl + 1][pl + 1];
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        dp[0][0] = true;
        for (int i = 1; i <= pl; ++i) {
            if (pc[i - 1] == '*') dp[0][i] = dp[0][i - 1];
        }
        for (int i = 1; i <= sl; ++i) {
            for (int j = 1; j <= pl; ++j) {
                if (pc[j - 1] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (sc[i - 1] == pc[j - 1] || pc[j - 1] == '?');
                } else {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                }
            }
        }
        return dp[sl][pl];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));     // false
        System.out.println(solution.isMatch("aa", "aa"));    // true
        System.out.println(solution.isMatch("aaa", "aa"));   // false
        System.out.println(solution.isMatch("aa", "*"));     // true
        System.out.println(solution.isMatch("aa", "a*"));    // true
        System.out.println(solution.isMatch("ab", "?*"));    // true
        System.out.println(solution.isMatch("aab", "c*a*b"));// false
    }
}
