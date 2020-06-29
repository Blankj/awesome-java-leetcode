package com.blankj.medium._011;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/23
 *     desc  :
 * </pre>
 */
public class Solution {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int max = 0, h = 0;
        while (l < r) {
            h = Math.min(height[l], height[r]);
            max = Math.max(max, (r - l) * h);
            while (height[l] <= h && l < r) ++l;
            while (height[r] <= h && l < r) --r;
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxArea(new int[]{1, 2, 4, 3})); // 4
        System.out.println(solution.maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));// 49
    }
}