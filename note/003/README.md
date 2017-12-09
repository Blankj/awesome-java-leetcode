# [Longest Substring Without Repeating Characters][title]

## Description

Given a string, find the length of the **longest substring** without repeating characters.

**Examples:**

Given `"abcabcbb"`, the answer is `"abc"`, which the length is 3.

Given `"bbbbb"`, the answer is `"b"`, with the length of 1.

Given `"pwwkew"`, the answer is `"wke"`, with the length of 3. Note that the answer must be a **substring**, `"pwke"` is a *subsequence* and not a substring.

**Tags:** Hash Table, Two Pointers, String


## 思路

题意是计算不带重复字符的最长子字符串的长度，开辟一个 hash 数组来存储该字符上次出现的位置，比如 `hash[a] = 3` 就是代表 `a` 字符前一次出现的索引在 3，遍历该字符串，获取到上次出现的最大索引（只能向前，不能退后），与当前的索引做差获取的就是本次所需长度，从中迭代出最大值就是最终答案。

```java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        int len;
        if (s == null || (len = s.length()) == 0) return 0;
        int preP = 0, max = 0;
        int[] hash = new int[128];
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (hash[c] > preP) {
                preP = hash[c];
            }
            int l = i - preP + 1;
            hash[c] = i + 1;
            if (l > max) max = l;
        }
        return max;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/longest-substring-without-repeating-characters
[ajl]: https://github.com/Blankj/awesome-java-leetcode
