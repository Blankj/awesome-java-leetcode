# [Implement strStr()][title]

## Description

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

**Tags:** Two Pointers, String


## 思路

题意是从主串中找到子串的索引，如果找不到则返回-1，当字串长度大于主串，直接返回-1，然后我们只需要遍历比较即可。

```java
class Solution {
    public int strStr(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        if (l1 < l2) return -1;
        for (int i = 0; ; i++) {
            for (int j = 0; ; j++) {
                if (j == l2) return i;
                if (i + j == l1) return -1;
                if (haystack.charAt(i + j) != needle.charAt(j)) break;
            }
        }
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/implement-strstr
[ajl]: https://github.com/Blankj/awesome-java-leetcode
