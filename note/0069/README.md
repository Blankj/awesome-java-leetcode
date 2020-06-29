# [Sqrt(x)][title]

## Description

Implement `int sqrt(int x)`.

Compute and return the square root of *x*, where *x* is guaranteed to be a non-negative integer.

Since the return type is an integer, the decimal digits are truncated and only the integer part of the result is returned.

**Example 1:**

```
Input: 4
Output: 2
```

**Example 2:**

```
Input: 8
Output: 2
Explanation: The square root of 8 is 2.82842..., and since 
             the decimal part is truncated, 2 is returned.
```

**Tags:** Binary Search, Math


## 思路

题意是求平方根，参考 [牛顿迭代法求平方根](https://wenku.baidu.com/view/6b74c622bcd126fff7050bfe.html)，然后再参考维基百科的 [Integer square root](https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division) 即可。

```java
class Solution {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/sqrtx
[ajl]: https://github.com/Blankj/awesome-java-leetcode
