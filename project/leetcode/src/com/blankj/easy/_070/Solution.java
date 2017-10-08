package com.blankj.easy._070;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/09
 *     desc  :
 * </pre>
 */
public class Solution {
    public int climbStairs(int n) {
        int a = 1, b = 1;
        while (--n > 0) {
            b += a;
            a = b - a;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.climbStairs(3));
    }
}
