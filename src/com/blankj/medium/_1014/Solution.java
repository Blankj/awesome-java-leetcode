package com.blankj.medium._1014;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2020/06/18
 *     desc  :
 * </pre>
 */
public class Solution {

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
