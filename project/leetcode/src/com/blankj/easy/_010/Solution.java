package com.blankj.easy._010;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/24
 *     desc  :
 * </pre>
 */
public class Solution {
//    public boolean isMatch(String s, String p) {
//        if (p.length() == 0) return s.length() == 0;
//        if (p.length() == 1) {
//            if (s.length() < 1) return false;
//            if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') return false;
//            return isMatch(s.substring(1), p.substring(1));
//        }
//        if (p.charAt(1) != '*') {
//            if (s.length() < 1) return false;
//            if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') return false;
//            return isMatch(s.substring(1), p.substring(1));
//        } else {
//            // match 0 preceding element
//            if (isMatch(s, p.substring(2))) return true;
//            int i = 0;
//            // match 1 or more preceding element
//            while (i < s.length() && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.')) {
//                if (isMatch(s.substring(i + 1), p.substring(2))) {
//                    return true;
//                }
//                ++i;
//            }
//            return false;
//        }
//    }

    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int sL = s.length(), pL = p.length();
        boolean[][] dp = new boolean[sL + 1][pL + 1];
        dp[0][0] = true;
        for (int i = 1; i < pL; ++i) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < sL; ++i) {
            for (int j = 0; j < pL; ++j) {
                char c1 = s.charAt(i), c2 = p.charAt(j);
                if (c2 == '.' || c2 == c1) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                if (c2 == '*') {
                    c2 = p.charAt(j - 1);
                    if (c2 == c1 || c2 == '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1];
                    } else {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1];
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
