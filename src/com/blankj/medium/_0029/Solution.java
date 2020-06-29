package com.blankj.medium._029;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/31
 *     desc  :
 * </pre>
 */
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        long dvd = Math.abs((long) dividend);
        long dvr = Math.abs((long) divisor);
        int res = 0;
        while (dvd >= dvr) {
            long temp = dvr, multiple = 1;
            while (dvd >= temp << 1) {
                temp <<= 1;
                multiple <<= 1;
            }
            dvd -= temp;
            res += multiple;
        }
        return (dividend < 0) ^ (divisor < 0) ? -res : res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(-2147483648, 1));
    }
}
