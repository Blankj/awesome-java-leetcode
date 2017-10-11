package com.blankj.easy._121;


/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/11
 *     desc  :
 * </pre>
 */
public class Solution {
    public int maxProfit(int[] prices) {
        int max = 0, minPrice = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; ++i) {
            if (prices[i] < minPrice) minPrice = prices[i];
            int delta = prices[i] - minPrice;
            if (delta > max) max = delta;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(solution.maxProfit(new int[]{7, 6, 4, 3, 1}));
    }
}
