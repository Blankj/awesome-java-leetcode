# [Climbing Stairs][title]

## Description

You are climbing a stair case. It takes *n* steps to reach to the top.

Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?

**Note:** Given *n* will be a positive integer.

**Tags:** Dynamic Programming


## 思路

题意是爬楼梯，每次你只能爬一步或者两步，问到顶层共有多少种方案。我们假设到顶层共有`f(n)`种，那么`f(n) = f(n - 1) + f(n - 2)`肯定是成立的，意思就是我们迈向顶层的最后一步是在倒数第一级台阶或者在倒数第二级台阶。算法我对空间复杂度进行了优化，因为在迭代过程中只需要两个变量即可。

``` java
public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            b += a;
            a = b - a;
        }
        return b;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/climbing-stairs
[ajl]: https://github.com/Blankj/awesome-java-leetcode
