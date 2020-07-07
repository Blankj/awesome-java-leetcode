package com.blankj.medium._0067;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2020/07/07
 *     desc  :
 * </pre>
 */
public class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = {{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}
