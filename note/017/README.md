# [Letter Combinations of a Phone Number][title]

## Description

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.

![img](https://upload.wikimedia.org/wikipedia/commons/thumb/7/73/Telephone-keypad2.svg/200px-Telephone-keypad2.svg.png)

**Example:**

```
Input: "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
```

**Note:**

Although the above answer is in lexicographical order, your answer could be in any order you want.

**Tags:** String, Backtracking


## 思路 0

题意是给你按键，让你组合出所有不同结果，首先想到的肯定是回溯了，对每个按键的所有情况进行回溯，回溯的终点就是结果字符串长度和按键长度相同。

```java
class Solution {
    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        List<String> list = new ArrayList<>();
        helper(list, digits, "");
        return list;
    }

    private void helper(List<String> list, String digits, String ans) {
        if (ans.length() == digits.length()) {
            list.add(ans);
            return;
        }
        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
            helper(list, digits, ans + c);
        }
    }
}
```

## 思路 1

还有一种思路就是利用队列，根据上一次队列中的值，该值拼接当前可选值来不断迭代其结果，具体代码如下。

```java
class Solution {
    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        char[] charArray = digits.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];
            while (list.getFirst().length() == i) {
                String pop = list.removeFirst();
                for (char v : map[c - '2'].toCharArray()) {
                    list.addLast(pop + v);
                }
            }
        }
        return list;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/letter-combinations-of-a-phone-number
[ajl]: https://github.com/Blankj/awesome-java-leetcode
