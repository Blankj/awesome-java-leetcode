package com.blankj.hard._044;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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

//    public boolean isMatch(String s, String p) {
//        if (p.length() == 0) return s.length() == 0;
//        int sl = s.length(), pl = p.length();
//        boolean[][] dp = new boolean[sl + 1][pl + 1];
//        char[] sc = s.toCharArray(), pc = p.toCharArray();
//        dp[0][0] = true;
//        for (int i = 1; i <= pl; ++i) {
//            if (pc[i - 1] == '*') dp[0][i] = dp[0][i - 1];
//        }
//        for (int i = 1; i <= sl; ++i) {
//            for (int j = 1; j <= pl; ++j) {
//                if (pc[j - 1] != '*') {
//                    dp[i][j] = dp[i - 1][j - 1] && (sc[i - 1] == pc[j - 1] || pc[j - 1] == '?');
//                } else {
//                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
//                }
//            }
//        }
//        return dp[sl][pl];
//    }

    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        if (len == 0) return Collections.emptyList();
        List<String> ans = new ArrayList<>();
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < maxWidth; ++i) {
            spaces.append(" ");
        }
        int sLen = -1, left = 0;
        for (int i = 0; i < len; ++i) {
            if (sLen + words[i].length() + 1 <= maxWidth) {
                sLen += words[i].length() + 1;
            } else {
                StringBuilder sub = new StringBuilder(words[left]);
                int rest = maxWidth - sLen;
                int seg = i - left;
                if (seg == 0) {
                    sub.append(spaces.substring(0, rest));
                } else {
                    int leastSpace = rest / seg + 1;
                    int restSpace = rest % seg;
                    for (int j = left + 1; j < i; ++j) {
                        if (restSpace-- > 0) {
                            sub.append(spaces.substring(0, leastSpace + 1)).append(words[j]);
                        } else {
                            sub.append(spaces.substring(0, leastSpace)).append(words[j]);
                        }
                    }
                }
                ans.add(sub.toString());
                left = i;
                sLen = words[i].length();
            }
        }
        StringBuilder sub = new StringBuilder(words[left]);
        for (int i = left + 1; i < len; ++i) {
            sub.append(" ").append(words[i]);
        }
        ans.add(sub + spaces.substring(0, maxWidth - sub.length()));
        return ans;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"", ""}, 0));
        System.out.println(solution.fullJustify(new String[]{"a"}, 1));
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
