package com.blankj.easy._069;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/08
 *     desc  :
 * </pre>
 */
public class Solution {
    public int mySqrt(int x) {
        long n = x;
        while (n * n > x) {
            n = (n + x / n) >> 1;
        }
        return (int) n;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(10));
    }
}
