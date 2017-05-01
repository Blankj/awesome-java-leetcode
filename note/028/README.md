# [Implement strStr()][title]

## Description

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

**Tags:** Two Pointers, String


## 思路

题意是从主串中找到子串的索引，如果找不到则返回-1，我们只需要遍历主串长度减字串长度即可，利用substring比较即可。

``` java
public class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length(), l3 = l1 - l2;
        int l3 = l1 - l2;
        for (int i = 0; i <= l3; ++i) {
            if (haystack.substring(i, i + l2).equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/implement-strstr
[ajl]: https://github.com/Blankj/awesome-java-leetcode
