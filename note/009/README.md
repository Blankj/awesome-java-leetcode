# [Palindrome Number][title]

## Description

Determine whether an integer is a palindrome. Do this without extra space.

**Spoilers:**

**Some hints:**

Could negative integers be palindromes? (ie, -1)

If you are thinking of converting the integer to string, note the restriction of using extra space.

You could also try reversing an integer. However, if you have solved the problem "Reverse Integer", you know that the reversed integer might overflow. How would you handle such case?

There is a more generic way of solving this problem.

**Tags:** Math


## 思路 0

题意是判断一个有符号整型数是否是回文，也就是逆序过来的整数和原整数相同，首先负数肯定不是，接下来我们分析一下最普通的解法，就是直接算出他的回文数，然后和给定值比较即可。

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int copyX = x, reverse = 0;
        while (copyX > 0) {
            reverse = reverse * 10 + copyX % 10;
            copyX /= 10;
        }
        return x == reverse;
    }
}
```

## 思路 1

好好思考下是否需要计算整个长度，比如 1234321，其实不然，我们只需要计算一半的长度即可，就是在计算过程中的那个逆序数比不断除 10 的数大就结束计算即可，但是这也带来了另一个问题，比如 10 的倍数的数 10010，它也会返回 `true`，所以我们需要对 10 的倍数的数再加个判断即可，代码如下所示。

```java
class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return halfReverseX == x || halfReverseX / 10 == x;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/palindrome-number
[ajl]: https://github.com/Blankj/awesome-java-leetcode
