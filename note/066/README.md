# [Plus One][title]

## Description

Given a non-negative integer represented as a **non-empty** array of digits, plus one to the integer.

You may assume the integer do not contain any leading zero, except the number 0 itself.

The digits are stored such that the most significant digit is at the head of the list.

**Tags:** Array, Math


## 思路

题意是给你一个数字数组，高位在前，并且首位不为 0 除非这个数组就是 `[0]`，让你给该数组低位加一求其结果，那么我们就模拟小学数学那样进位去算即可，如果一直进位到首位，这种情况也就是都是由 9 组成的数组，此时我们只要 new 出一个多一个长度的数组即可，并把第 0 个元素赋 1 即可。

```java
class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        if (digits[p] < 9) {
            digits[p] = ++digits[p];
        } else {
            do {
                digits[p--] = 0;
            } while (p >= 0 && digits[p] == 9);
            if (digits[0] != 0) {
                ++digits[p];
            } else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/plus-one
[ajl]: https://github.com/Blankj/awesome-java-leetcode
