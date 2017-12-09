# [Pascal's Triangle II][title]

## Description

Given an index *k*, return the *k*<sup>th</sup> row of the Pascal's triangle.

For example, given *k* = 3,

Return `[1,3,3,1]`.

**Note:**

Could you optimize your algorithm to use only *O*(*k*) extra space?

**Tags:** Array


## 思路

题意是指定输出帕斯卡尔三角形的某一行，模拟即可，优化后的代码如下所示。

```java
class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/pascals-triangle-ii
[ajl]: https://github.com/Blankj/awesome-java-leetcode
