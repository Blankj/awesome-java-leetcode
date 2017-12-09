# [Pow(x, n)][title]

## Description

Implement [pow(*x*, *n*)](http://www.cplusplus.com/reference/valarray/pow/).

**Example 1:**

```
Input: 2.00000, 10
Output: 1024.00000
```

**Example 2:**

```
Input: 2.10000, 3
Output: 9.26100
```

**Tags:** Math, Binary Search


## 思路

题意是让你计算 `x^n`，如果直接计算肯定会超时，那么我们可以想到可以使用二分法来降低时间复杂度。

```java
class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return helper(1 / x, -n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double d = helper(x, n >>> 1);
        if (n % 2 == 0) return d * d;
        return d * d * x;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/powx-n
[ajl]: https://github.com/Blankj/awesome-java-leetcode
