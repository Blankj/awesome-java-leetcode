# [Regular Expression Matching][title]

## Description

Implement regular expression matching with support for `'.'` and `'*'`.

```
'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa", "a") → false
isMatch("aa", "aa") → true
isMatch("aaa", "aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true
```

**Tags:** String, Dynamic Programmin, Backtracking


## 思路0

题意是


``` java
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.length() == 1) {
            if (s.length() < 1) return false;
            if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') return false;
            return true;
        }
        if (p.charAt(1) != '*') {
            if (s.length() < 1) return false;
            if (p.charAt(0) != s.charAt(0) && p.charAt(0) != '.') return false;
            return isMatch(s.substring(1), p.substring(1));
        } else {
            // match 0 preceding element
            if (isMatch(s, p.substring(2))) return true;
            int i = 0;
            // match 1 or more preceding element
            while (i < s.length() && (p.charAt(0) == s.charAt(i) || p.charAt(0) == '.')) {
                if (isMatch(s.substring(i + 1), p.substring(2))) {
                    return true;
                }
                ++i;
                return false;
            }
        }
    }
}
```


``` java
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        if (p.contains(".*")) return true;
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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/regular-expression-matching
[ajl]: https://github.com/Blankj/awesome-java-leetcode
