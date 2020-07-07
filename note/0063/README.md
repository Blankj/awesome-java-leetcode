# [不同路径 II(Unique Paths II)][title]

## 题目描述

一个机器人位于一个 _m x n_ 网格的左上角 （起始点在下图中标记为“Start” ）。

机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。

现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2018/10/22/robot_maze.png)

网格中的障碍物和空位置分别用 `1` 和 `0` 来表示。

**说明：**_m_ 和 _n_ 的值均不超过 100。

**示例 1:**
```
输入:
[
  [0,0,0],
  [0,1,0],
  [0,0,0]
]
输出: 2
解释:
3x3 网格的正中间有一个障碍物。
从左上角到右下角一共有 2 条不同的路径：
1. 向右 -> 向右 -> 向下 -> 向下
2. 向下 -> 向下 -> 向右 -> 向右
```

**标签：** 数组、动态规划


## 思路

做过爬楼梯的应该很快就能想到这是一道很典型的动态规划题目，

我们令 `dp[i][j]` 表示走到格子 `(i, j)` 的路径数，

那么当 `(i, j)` 没障碍物时，`dp[i][j] = 0`；

那么当 `(i, j)` 有障碍物时，`dp[i][j] = dp[i - 1][j] + dp[i][j - 1]`；

其初始态第 1 列（行）的格子只有从其上（左）边格子走过去这一种走法，因此初始化 `dp[i][0]`（`dp[0][j]`）值为 1，且遇到障碍物时后面值都为 0；

有了这些条件，我相信你肯定可以写出代码来了，具体如下所示：


```java
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] dp = new int[m][n];
        // 其初始态第 1 列（行）的格子只有从其上（左）边格子走过去这一种走法，
        // 因此初始化 dp[i][0]（dp[0][j]）值为 1，且遇到障碍物时后面值都为 0；
        for (int i = 0; i < m && obstacleGrid[i][0] == 0; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n && obstacleGrid[0][j] == 0; j++) {
            dp[0][j] = 1;
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 0) {
                    // 当 (i, j) 有障碍物时，dp[i][j] = dp[i - 1][j] + dp[i][j - 1]；
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }
        return dp[m - 1][n - 1];
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode-cn.com/problems/unique-paths-ii
[ajl]: https://github.com/Blankj/awesome-java-leetcode
