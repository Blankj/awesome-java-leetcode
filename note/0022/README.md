# [Generate Parentheses][title]

## Description

Given *n* pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given *n* = 3, a solution set is:

```
[
  "((()))",
  "(()())",
  "(())()",
  "()(())",
  "()()()"
]
```

**Tags:** String, Backtracking


## 思路 0

题意是给你 `n` 值，让你找到所有格式正确的圆括号匹配组，题目中已经给出了 `n = 3` 的所有结果。遇到这种问题，第一直觉就是用到递归或者堆栈，我们选取递归来解决，也就是 `helper` 函数的功能，从参数上来看肯定很好理解了，`leftRest` 代表还有几个左括号可以用，`rightNeed` 代表还需要几个右括号才能匹配，初始状态当然是 `rightNeed = 0, leftRest = n`，递归的终止状态就是 `rightNeed == 0 && leftRest == 0`，也就是左右括号都已匹配完毕，然后把 `str` 加入到链表中即可。

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        helper(list, "", 0, n);
        return list;
    }

    private void helper(List<String> list, String str, int rightNeed, int leftRest) {
        if (rightNeed == 0 && leftRest == 0) {
            list.add(str);
            return;
        }
        if (rightNeed > 0) helper(list, str + ")", rightNeed - 1, leftRest);
        if (leftRest > 0) helper(list, str + "(", rightNeed + 1, leftRest - 1);
    }
}
```


## 思路 1

另一种实现方式就是迭代的思想了，我们来找寻其规律如下所示：

```
f(0): “”

f(1): “(“f(0)”)”

f(2): "(“f(0)”)"f(1), “(“f(1)”)”

f(3): "(“f(0)”)"f(2), "(“f(1)”)"f(1), “(“f(2)”)”
...
```

可以递推出 `f(n) = "(“f(0)”)"f(n-1) , "(“f(1)”)"f(n-2) "(“f(2)”)"f(n-3) … "(“f(i)”)“f(n-1-i) … “(f(n-1)”)”`

根据如上递推式写出如下代码应该不难了吧。

```java
class Solution {
    public List<String> generateParenthesis(int n) {
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        hashMap.put(0, Collections.singletonList(""));
        for (int i = 1; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String fj : hashMap.get(j)) {
                    for (String fi_j_1 : hashMap.get(i - j - 1)) {
                        list.add("(" + fj + ")" + fi_j_1);// calculate f(i)
                    }
                }
            }
            hashMap.put(i, list);
        }
        return hashMap.get(n);
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/generate-parentheses
[ajl]: https://github.com/Blankj/awesome-java-leetcode
