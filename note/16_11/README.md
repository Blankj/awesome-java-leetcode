# [跳水板(Diving Board LCCI)][title]

## 题目描述

你正在使用一堆木板建造跳水板。有两种类型的木板，其中长度较短的木板长度为`shorter`，长度较长的木板长度为`longer`。你必须正好使用`k`块木板。编写一个方法，生成跳水板所有可能的长度。

返回的长度需要从小到大排列。

**示例：**

```
输入：
shorter = 1
longer = 2
k = 3
输出： {3,4,5,6}
```

**提示：**

*   0 < shorter <= longer
*   0 <= k <= 100000

**标签：** 递归、记忆化


## 思路

这题乍一看，好像得用递归或动态规划来解，仔细一想，其实就是高中数学学过的等差数列知识。

当 `k == 0` 时，返回 `[]` 即可；

当 `shorter == longer` 时，返回 `[k * shorter]` 即可；

当 `shorter != longer` 时，那么其实就是一个首项为 `k * shorter`，末项为 `k * longer`，公差为 `longer - shorter` 的等差数列么；

我们根据以上情况就可以写出如下代码了：


```java
public class Solution {
    public int[] divingBoard(int shorter, int longer, int k) {
        if (k == 0) {
            return new int[0];
        }
        if (shorter == longer) {
            return new int[]{shorter * k};
        }
        int[] ans = new int[k + 1];
        int st = k * shorter;// 等差数列的首项
        int delta = longer - shorter;// 公差
        for (int i = 0; i <= k; i++) {
            ans[i] = st + i * delta;
        }
        return ans;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode-cn.com/problems/diving-board-lcci
[ajl]: https://github.com/Blankj/awesome-java-leetcode
