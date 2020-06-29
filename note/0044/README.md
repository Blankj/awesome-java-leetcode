# [Wildcard Matching][title]

## Description

Given an input string (`s`) and a pattern (`p`), implement wildcard pattern matching with support for `'?'` and `'*'`.

```
'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).
```

The matching should cover the **entire** input string (not partial).

**Note:**

- `s` could be empty and contains only lowercase letters `a-z`.
- `p` could be empty and contains only lowercase letters `a-z`, and characters like `?` or `*`.

**Example 1:**

```
Input:
s = "aa"
p = "a"
Output: false
Explanation: "a" does not match the entire string "aa".
```

**Example 2:**

```
Input:
s = "aa"
p = "*"
Output: true
Explanation: '*' matches any sequence.
```

**Example 3:**

```
Input:
s = "cb"
p = "?a"
Output: false
Explanation: '?' matches 'c', but the second letter is 'a', which does not match 'b'.
```

**Example 4:**

```
Input:
s = "adceb"
p = "*a*b"
Output: true
Explanation: The first '*' matches the empty sequence, while the second '*' matches the substring "dce".
```

**Example 5:**

```
Input:
s = "acdcb"
p = "a*c?b"
Output: false
```

**Tags:** String, Dynamic Programming, Backtracking, Greedy


## 思路 0

题意是让让你从判断 `s` 字符串是否通配符匹配于 `p`，这道题和[Regular Expression Matching][010]很是相似，区别在于 `*`，正则匹配的 `*` 不能单独存在，前面必须具有一个字符，其意义是表明前面的这个字符个数可以是任意个数，包括 0 个；而通配符的 `*` 是可以随意出现的，跟前面字符没有任何关系，其作用是可以表示任意字符串。在此我们可以利用 *贪心算法* 来解决这个问题，需要两个额外指针 `p` 和 `match` 来分别记录最后一个 `*` 的位置和 `*` 匹配到 `s` 字符串的位置，其贪心体现在如果遇到 `*`，那就尽可能取匹配后方的内容，如果匹配失败，那就回到上一个遇到 `*` 的位置来继续贪心。

```java
class Solution {
    public boolean isMatch(String s, String p) {
        if (p.length() == 0) return s.length() == 0;
        int si = 0, pi = 0, match = 0, star = -1;
        int sl = s.length(), pl = p.length();
        char[] sc = s.toCharArray(), pc = p.toCharArray();
        while (si < sl) {
            if (pi < pl && (pc[pi] == sc[si] || pc[pi] == '?')) {
                si++;
                pi++;
            } else if (pi < pl && pc[pi] == '*') {
                star = pi++;
                match = si;
            } else if (star != -1) {
                si = ++match;
                pi = star + 1;
            } else return false;
        }
        while (pi < pl && pc[pi] == '*') pi++;
        return pi == pl;
    }
}
```


## 思路 1

另一种思路就是动态规划了，我们定义 `dp[i][j]` 的真假来表示 `s[0..i)` 是否匹配 `p[0..j)`，其状态转移方程如下所示：

* 如果 `p[j - 1] != '*'`，`P[i][j] = P[i - 1][j - 1] && (s[i - 1] == p[j - 1] || p[j - 1] == '?');`

* 如果 `p[j - 1] == '*'`，`P[i][j] = P[i][j - 1] || P[i - 1][j]`

```java
class Solution {
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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[010]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/010/README.md
[title]: https://leetcode.com/problems/wildcard-matching
[ajl]: https://github.com/Blankj/awesome-java-leetcode
