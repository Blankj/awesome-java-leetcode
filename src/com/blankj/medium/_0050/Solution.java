package com.blankj.medium._050;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/18
 *     desc  :
 * </pre>
 */
public class Solution {
    public double myPow(double x, int n) {
        if (n < 0) return helper(1 / x, -n);
        return helper(x, n);
    }

    private double helper(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double d = helper(x, n >>> 1);
        if (n % 2 == 0) return d * d;
        return d * d * x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myPow(8.88023, 3));
    }
}
