# [Longest Valid Parentheses][title]

## Description

Given a string containing just the characters `(` and `)`, find the length of the longest valid (well-formed) parentheses substring.

**Example 1:**
```
Input: s = "(()"
Output: 2
Explanation: The longest valid parentheses substring is "()".
```

**Example 2:**
```
Input: s = ")()())"
Output: 4
Explanation: The longest valid parentheses substring is "()()".
```

**Tags:** String, Dynamic Programming, Stack

## Solution 0 - Stack

Use a stack to track indices. Push -1 as base. For each `(` push its index. For each `)` pop and calculate length using the current index minus the new top.

```java
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        java.util.Deque<Integer> stack = new java.util.ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    max = Math.max(max, i - stack.peek());
                }
            }
        }
        return max;
    }
}
```

## Solution 1 - Dynamic Programming

Let dp[i] be the length of the longest valid parentheses ending at index i. If s[i] == ')' and s[i-1] == '(', dp[i] = dp[i-2] + 2. If s[i] == ')' and s[i-1] == ')', check if s[i - dp[i-1] - 1] == '(', then dp[i] = dp[i-1] + dp[i - dp[i-1] - 2] + 2.

```java
class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (dp[i - 1] > 0) {
                    int j = i - dp[i - 1] - 1;
                    if (j >= 0 && s.charAt(j) == '(') {
                        dp[i] = dp[i - 1] + (j >= 1 ? dp[j - 1] : 0) + 2;
                    }
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }
}
```

[title]: https://leetcode.com/problems/longest-valid-parentheses
