package com.blankj.easy._066;

import java.util.Arrays;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/06
 *     desc  :
 * </pre>
 */
public class Solution {
    public int[] plusOne(int[] digits) {
        int p = digits.length - 1;
        if (digits[p] < 9) {
            digits[p] = ++digits[p];
        } else {
            do {
                digits[p--] = 0;
            } while (p >= 0 && digits[p] == 9);
            if (digits[0] != 0) {
                ++digits[p];
            } else {
                digits = new int[digits.length + 1];
                digits[0] = 1;
            }
        }
        return digits;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = solution.plusOne(new int[]{9, 9, 9});
        System.out.println(Arrays.toString(digits));
    }
}
