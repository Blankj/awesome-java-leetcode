# [Add Binary][title]

## Description

Given two binary strings, return their sum (also a binary string).

The input strings are both **non-empty** and contains only characters `1` or `0`.

**Example 1:**

```
Input: a = "11", b = "1"
Output: "100"
```

**Example 2:**

```
Input: a = "1010", b = "1011"
Output: "10101"
```

**Tags:** Math, String


## 思路

题意是给你两个二进制串，求其和的二进制串。我们就按照小学算数那么来做，用 `carry` 表示进位，从后往前算，依次往前，每算出一位就插入到最前面即可，直到把两个二进制串都遍历完即可。

```java
class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/add-binary
[ajl]: https://github.com/Blankj/awesome-java-leetcode
