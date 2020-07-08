package com.blankj.easy._16_11;

import java.util.Arrays;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2020/07/08
 *     desc  :
 * </pre>
 */
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(Arrays.toString(solution.divingBoard(1, 2, 3)));
    }
}
