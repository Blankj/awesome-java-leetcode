# [Multiply Strings][title]

## Description

1. Given two non-negative integers `num1` and `num2` represented as strings, return the product of `num1` and `num2`, also represented as a string.

   **Example 1:**

   ```
   Input: num1 = "2", num2 = "3"
   Output: "6"
   ```

   **Example 2:**

   ```
   Input: num1 = "123", num2 = "456"
   Output: "56088"
   ```

   **Note:**

   1. The length of both `num1` and `num2` is < 110.
   2. Both `num1` and `num2` contain only digits `0-9`.
   3. Both `num1` and `num2` do not contain any leading zero, except the number 0 itself.
   4. You **must not use any built-in BigInteger library** or **convert the inputs to integer** directly.

**Tags:** Math, String


## 思路

题意是让你计算两个非负字符串的乘积，我们模拟小学数学的方式来做，一位一位模拟计算，再各位累加。

```java
class Solution {
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) return "0";
        int l1 = num1.length(), l2 = num2.length(), l = l1 + l2;
        char[] ans = new char[l];
        char[] c1 = num1.toCharArray();
        char[] c2 = num2.toCharArray();
        for (int i = l1 - 1; i >= 0; --i) {
            int c = c1[i] - '0';
            for (int j = l2 - 1; j >= 0; --j) {
                ans[i + j + 1] +=  c * (c2[j] - '0');
            }
        }
        for (int i = l - 1; i > 0; ++i) {
            if (ans[i] > 9) {
                ans[i - 1] += ans[i] / 10;
                ans[i] %= 10;        
            }
         }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        for (; ; ++i) if (ans[i] != 0) break;
        for (; i < ans.length; ++i) sb.append((char) (ans[i] + '0'));
        return sb.toString();
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/multiply-strings
[ajl]: https://github.com/Blankj/awesome-java-leetcode
