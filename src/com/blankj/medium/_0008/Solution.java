package com.blankj.medium._008;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/23
 *     desc  :
 * </pre>
 */
public class Solution {
    public int myAtoi(String str) {
        int i = 0, ans = 0, sign = 1, len = str.length();
        while (i < len && str.charAt(i) == ' ') ++i;
        if (i < len && (str.charAt(i) == '-' || str.charAt(i) == '+')) {
            sign = str.charAt(i++) == '+' ? 1 : -1;
        }
        for (; i < len; ++i) {
            int tmp = str.charAt(i) - '0';
            if (tmp < 0 || tmp > 9) break;
            if (ans > Integer.MAX_VALUE / 10
                    || (ans == Integer.MAX_VALUE / 10 && (sign == 1 && tmp > 7 || sign == -1 && tmp > 8))) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            } else {
                ans = ans * 10 + tmp;
            }
        }
        return sign * ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.myAtoi("   +1"));
        System.out.println(solution.myAtoi("   -1"));
        System.out.println(solution.myAtoi(""));
        System.out.println(solution.myAtoi("a1"));
        System.out.println(solution.myAtoi("100000000000000000000"));
        System.out.println(solution.myAtoi("-100000000000000000000"));
        System.out.println(solution.myAtoi("-3924x8fc"));
        System.out.println(solution.myAtoi(String.valueOf(Integer.MIN_VALUE)));
        System.out.println(solution.myAtoi(String.valueOf(Integer.MAX_VALUE)));
    }
}