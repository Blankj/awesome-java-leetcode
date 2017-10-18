package com.blankj.hard._010;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/13
 *     desc  :
 * </pre>
 */
public class Solution {
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//        if (p.length() == 1) {
//            return s.length() == 1 && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.');
//        }
//        if (p.charAt(1) != '*') {
//            if (s.isEmpty()) return false;
//            return (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
//                    && isMatch(s.substring(1), p.substring(1));
//        }
//        // match 1 or more preceding element
//        while (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')) {
//            if (isMatch(s, p.substring(2))) return true;
//            s = s.substring(1);
//        }
//        // match 0 preceding element
//        return isMatch(s, p.substring(2));
//    }
//
//    public boolean isMatch(String s, String p) {
//        if (p.isEmpty()) return s.isEmpty();
//        if (p.length() > 1 && p.charAt(1) == '*') {
//            return isMatch(s, p.substring(2))
//                    || (!s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
//                    && isMatch(s.substring(1), p));
//        }
//        return !s.isEmpty() && (p.charAt(0) == s.charAt(0) || p.charAt(0) == '.')
//                && isMatch(s.substring(1), p.substring(1));
//    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int sL = s.length(), pL = p.length();
        boolean[][] dp = new boolean[sL + 1][pL + 1];
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        dp[0][0] = true;
        for (int i = 2; i <= pL; ++i) {
            if (pc[i - 1] == '*' && dp[0][i - 2]) {
                dp[0][i] = true;
            }
        }
        for (int i = 1; i <= sL; ++i) {
            for (int j = 1; j <= pL; ++j) {
                if (pc[j - 1] == '.' || pc[j - 1] == sc[i - 1]) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
                if (pc[j - 1] == '*') {
                    if (pc[j - 2] == sc[i - 1] || pc[j - 2] == '.') {
                        dp[i][j] = dp[i - 1][j] || dp[i][j - 2];
                    } else {
                        dp[i][j] = dp[i][j - 2];
                    }
                }
            }
        }
        return dp[sL][pL];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", "a"));     // false
        System.out.println(solution.isMatch("aa", "aa"));    // true
        System.out.println(solution.isMatch("aaa", "aa"));   // false
        System.out.println(solution.isMatch("aa", "a*"));    // true
        System.out.println(solution.isMatch("aa", ".*"));    // true
        System.out.println(solution.isMatch("ab", ".*"));    // true
        System.out.println(solution.isMatch("aab", "c*a*b"));// true
    }
}
