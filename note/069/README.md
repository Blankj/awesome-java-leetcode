# [Sqrt(x)][title]

## Description

Implement `int sqrt(int x)`.

Compute and return the square root of x.

**Tags:** Binary Search, Math


## 思路

题意是求平方根，参考[牛顿迭代法求平方根](https://wenku.baidu.com/view/6b74c622bcd126fff7050bfe.html)，然后再参考维基百科的[Integer square root](https://en.wikipedia.org/wiki/Integer_square_root#Using_only_integer_division)即可。

``` java
public class Solution {
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

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/sqrtx
[ajl]: https://github.com/Blankj/awesome-java-leetcode
