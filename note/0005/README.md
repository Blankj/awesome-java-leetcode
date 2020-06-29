# [Longest Palindromic Substring][title]

## Description

Given a string **s**, find the longest palindromic substring in **s**. You may assume that the maximum length of **s** is 1000.

**Example 1:**

```
Input: "babad"

Output: "bab"

Note: "aba" is also a valid answer.
```

**Example 2:**

```
Input: "cbbd"

Output: "bb"
```

**Tags:** String, Dynamic Programming


## 思路 0

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


## 思路 1

如果利用暴力法遍历所有字串是否回文的情况这道题肯定是 `Time Limit Exceeded` 的，那么我们是否可以把之前遍历的结果利用上呢，那么动态规划的想法就呼之欲出了，我们定义 `dp[i][j]` 的意思为字符串区间 `[i, j]` 是否为回文串，那么我们分三种情况：

1. 当 `i == j` 时，那么毫无疑问 `dp[i][j] = true`；

2. 当 `i + 1 == j` 时，那么 `dp[i][j]` 的值取决于 `s[i] == s[j]`；

3. 当 `i + 1 < j` 时，那么 `dp[i][j]` 的值取决于 `dp[i + 1][j - 1] && s[i] == s[j]`。

根据以上的动态转移方程，我们的问题即可迎刃而解，时间复杂度的话显而易见，也是 `O(n^2)`。

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


## 思路 2

马拉车算法(Manacher's Algorithm)

### 背景

给定一个字符串，求出其最长回文子串（回文字符串就是从左到右读和从右往左读完全一样，也就是字符串关于中间对称）。例如：

1. s = "babad"，最长回文长度为 `3`，可以是 `bab` 或者 `aba`；

2. s = "cbbda"，最长回文长度为 `2`，即 `bb`；

3. s = "abcde"，最长回文长度为 `1`，即单个字符本身。

这个问题等同于 LeetCode 上的 [Longest Palindromic Substring](https://leetcode.com/problems/longest-palindromic-substring)，其相关题解可以查看这里：[传送门](https://github.com/Blankj/awesome-java-leetcode/blob/master/note/005/README.md)

以上问题的传统思路大概是遍历每一个字符，以该字符为中心向两边查找，其时间复杂度为 `O(n^2)`，效率很差。

1975 年，一个叫 Manacher 的人发明了 Manacher 算法（中文名：马拉车算法），该算法可以把时间复杂度提升到 `O(n)`，下面我以我理解的思路来讲解其原理。


### 分析

由于回文串的奇偶行不确定，比如 `lol` 是奇回文，而 `lool` 是偶回文，马拉车算法的第一步就是对其进行预处理，做法就是在每个字符两侧都加上一个特殊字符，一般就是不会出现在原串中的即可，我们可以选取 `#`，那么

```
lol  -> #l#o#l#
lool -> #l#o#o#l#
```

这样处理后，不管原来字符串长度是奇数还是偶数，最终得到的长度都将是奇数，从而能把两种情况合并起来一起考虑，记预处理后的字符串为 `str`。

我们把一个回文串中最左或最右位置的字符与其对称轴的距离称为回文半径。

马拉车算法定义了一个回文半径数组 `len`，用 `len[i]` 表示以第 `i` 个字符为对称轴的回文串的回文半径，比如以 `str[i]` 为中心的最长回文串是 `str[l, r]`，那么 `len[i] = r - i + 1`

我们以 `lollool` 为例，参看下表。

| str   | #    | l    | #    | o    | #    | l    | #    | l    | #    | o    | #    | o    | #    | l    | #    |
| :---  | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- | :--- |
| len[] | 1    | 2    | 1    | 4    | l    | 2    | 5    | 2    | 1    | 2    | 5    | 2    | 1    | 2    | 1    |

可以发现 `len[i] - 1` 就等于该回文串在原串中的长度。

证明：在转换后的字符串 `str` 中，那么对于以 `str[i]` 为中心的最长回文串的长度为 `2 * len[i] - 1`，其中又有 `len[i]` 个分隔符，所以在原字符串中的回文串长度就是 `len[i] - 1`。

那么我们剩下的工作就是求 `len` 数组。

为了防止数组越界，我们在首位再加上非 `#` 的不常用字符，比如 `~`，那么 `lollool` 就表示为 `~#l#o#l#l#o#o#l#~`，这样我们就省去写很多 `if else` 的边界处理。

我们先看一张图，如下所示：



## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/longest-palindromic-substring
[ajl]: https://github.com/Blankj/awesome-java-leetcode
