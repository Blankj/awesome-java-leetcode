# [Reverse Integer][title]

## Description

Given a 32-bit signed integer, reverse digits of an integer.

**Example 1:**

```
Input: 123
Output:  321
```

**Example 2:**

```
Input: -123
Output: -321
```

**Example 3:**

```
Input: 120
Output: 21
```

**Note:**

Assume we are dealing with an environment which could only hold integers within the 32-bit signed integer range. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.

**Tags:** Math


## 思路

题意是给你一个整型数，求它的逆序整型数，而且有个小坑点，当它的逆序整型数溢出的话，那么就返回 0，用我们代码表示的话可以求得结果保存在 long 中，最后把结果和整型的两个范围比较即可。

```java
class Solution {
    public int reverse(int x) {
        long res = 0;
        for (; x != 0; x /= 10)
            res = res * 10 + x % 10;
        return res > Integer.MAX_VALUE || res < Integer.MIN_VALUE ? 0 : (int) res;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/reverse-integer
[ajl]: https://github.com/Blankj/awesome-java-leetcode
