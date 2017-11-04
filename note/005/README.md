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

题意是寻找出字符串中最长的回文串，所谓回文串就是正序和逆序相同的字符串，也就是关于中间对称。我们先用最常规的做法，依次去求得每个字符的最长回文，要注意每个字符有奇数长度的回文串和偶数长度的回文串两种情况，相信你可以很轻易地从如下代码中找到相关代码，记录最长回文的始末位置即可，时间复杂度的话，首先要遍历一遍字符串，然后对每个字符都去求得最长回文，所以时间复杂度为O(n^2)。

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



```java

```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/longest-palindromic-substring
[ajl]: https://github.com/Blankj/awesome-java-leetcode
