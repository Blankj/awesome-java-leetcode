# [最佳观光组合(Best Sightseeing Pair)][title]

## 题目描述

给定正整数数组 `A`，`A[i]` 表示第 `i` 个观光景点的评分，并且两个景点 `i` 和 `j` 之间的距离为 `j - i`。

一对景点（`i < j`）组成的观光组合的得分为（`A[i] + A[j] + i - j`）：景点的评分之和**减去**它们两者之间的距离。

返回一对观光景点能取得的最高分。

**示例：**

```
输入：[8,1,5,2,6]
输出：11
解释：i = 0, j = 2, A[i] + A[j] + i - j = 8 + 5 + 0 - 2 = 11
```

**提示：**

1.  `2 <= A.length <= 50000`
2.  `1 <= A[i] <= 1000`

**标签：** 数组


## 思路

直接暴力两层 for 循环肯定过不了关，我们把公式变化为 `(A[i] + i) + (A[j] - j)`，看到此应该就可以想到在每次遍历 `j` 时，只需要知道 `max(A[i] + i)` 即可。

```java
class Solution {

    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, cur = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, cur + A[j] - j); // 计算当前最大得分
            cur = Math.max(cur, A[j] + j);       // 更新最大的 A[i] + i
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{8, 1, 5, 2, 6};
        System.out.println(solution.maxScoreSightseeingPair(A));
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode-cn.com/problems/best-sightseeing-pair
[ajl]: https://github.com/Blankj/awesome-java-leetcode
