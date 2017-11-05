# [Longest Palindromic Substring][title]

## Description

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example:**

```
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.

```

**Example:**

```
Input: "cbbd"

Output: "bb"
```

**Tags:** String


## 思路0

题意是寻找出字符串中最长的回文串，所谓回文串就是正序和逆序相同的字符串，也就是关于中间对称。我们先用最常规的做法，依次去求得每个字符的最长回文，要注意每个字符有奇数长度的回文串和偶数长度的回文串两种情况，相信你可以很轻易地从如下代码中找到相关代码，记录最长回文的始末位置即可，时间复杂度的话，首先要遍历一遍字符串，然后对每个字符都去求得最长回文，所以时间复杂度为 `O(n^2)`。

```java
class Solution {
    int st, end;

    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        char[] chars = s.toCharArray();
        for (int i = 0; i < len; i++) {
            helper(chars, i, i);
            helper(chars, i, i + 1);
        }
        return s.substring(st, end + 1);
    }

    private void helper(char[] chars, int l, int r) {
        while (l >= 0 && r < chars.length && chars[l] == chars[r]) {
            --l;
            ++r;
        }
        if (end - st < r - l - 2) {
            st = l + 1;
            end = r - 1;
        }
    }
}
```


## 思路1

如果利用暴力法遍历所有字串是否回文的情况这道题肯定是 `Time Limit Exceeded` 的，那么我们是否可以把之前遍历的结果利用上呢，那么动态规划的想法就呼之欲出了，我们定义 `dp[i][j]` 的意思为字符串区间`[i, j]`是否为回文串，那么我们分三种情况：
1. 当 `i == j` 时，那么毫无疑问 `dp[i][j] = true`；
2. 当 `i + 1 == j` 时，那么 `dp[i][j]` 的值取决于 `s[i] == s[j]`；
3. 当 `i + 1 < j` 时，那么 `dp[i][j]` 的值取决于 `dp[i + 1][j - 1] && s[i] == s[j]`；
根据以上的动态转移方程，我们的问题即可迎刃而解，时间复杂度的话很显而易见，也是 `O(n^2)`。

```java
class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        if (len <= 1) return s;
        int st = 0, end = 0;
        char[] chars = s.toCharArray();
        boolean[][] dp = new boolean[len][len];
        for (int i = 0; i < len; i++) {
            dp[i][i] = true;
            for (int j = 0; j < i; j++) {
                if (j + 1 == i) {
                    dp[j][i] = chars[j] == chars[i];
                } else {
                    dp[j][i] = dp[j + 1][i - 1] && chars[j] == chars[i];
                }
                if (dp[j][i] && i - j > end - st) {
                    st = j;
                    end = i;
                }
            }
        }
        return s.substring(st, end + 1);
    }
}
```


## 思路2

最后一种思路那就是 `Manacher's Algorithm`，中文名叫马拉车算法，该算法就是专为解决此问题而发明的。


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/longest-palindromic-substring
[ajl]: https://github.com/Blankj/awesome-java-leetcode
