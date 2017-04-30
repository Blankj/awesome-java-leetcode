# [Valid Parentheses][title]

## Description

Given a string containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.

The brackets must close in the correct order, `"()"` and `"()[]{}"` are all valid but `"(]"` and `"([)]"` are not.

**Tags:** Stack, String


## 思路

题意是判断括号匹配是否正确，很明显，我们可以用栈来解决这个问题，当出现左括号的时候入栈，当遇到右括号时，判断栈顶的左括号是否何其匹配，不匹配的话直接返回`false`即可，最终判断是否空栈即可，这里我们可以用数组模拟栈的操作使其操作更快，有个细节注意下`top =  1;`，从而省去了之后判空的操作和`top - 1`导致数组越界的错误。

``` java
public class Solution {
    public boolean isValid(String s) {
        int len = s.length();
        char[] stack = new char[len + 1];
        int top = 1;
        for (int i = 0; i < len; ++i) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{')
                stack[top++] = c;
            else if (c == ')' && stack[top - 1] != '(')
                return false;
            else if (c == ']' && stack[top - 1] != '[')
                return false;
            else if (c == '}' && stack[top - 1] != '{')
                return false;
            else
                --top;
        }
        return top == 1;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我GitHub上的LeetCode题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/valid-parentheses
[ajl]: https://github.com/Blankj/awesome-java-leetcode
