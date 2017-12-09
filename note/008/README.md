# [String to Integer (atoi)][title]

## Description

Implement atoi to convert a string to an integer.

**Hint:** Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

**Notes:** It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

**Spoilers:**

**Requirements for atoi:**

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

**Tags:** Math, String


## 思路

题意是把一个字符串转为整型，但要注意所给的要求，先去除最前面的空格，然后判断正负数，注意正数可能包含 `+`，如果之后存在非数字或全为空则返回 `0`，而如果合法的值超过 int 表示的最大范围，则根据正负号返回 `INT_MAX` 或 `INT_MIN`。

```java
class Solution {
    public int myAtoi(String str) {
        int i = 0, ans = 0, sign = 1, len = str.length();
        while (i < len && str.charAt(i) == ' ') ++i;
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        for (; i < len; ++i) {
            int tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9)
                break;
            if (ans > Integer.MAX_VALUE / 10 || ans == Integer.MAX_VALUE / 10 && Integer.MAX_VALUE % 10 < tmp)
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            else
                ans = ans * 10 + tmp;
        }
        return sign * ans;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/string-to-integer-atoi
[ajl]: https://github.com/Blankj/awesome-java-leetcode
