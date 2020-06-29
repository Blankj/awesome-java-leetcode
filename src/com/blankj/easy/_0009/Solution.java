package com.blankj.easy._009;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/24
 *     desc  :
 * </pre>
 */
public class Solution {
//    public boolean isPalindrome(int x) {
//        if (x < 0) return false;
//        int copyX = x, reverse = 0;
//        while (copyX > 0) {
//            reverse = reverse * 10 + copyX % 10;
//            copyX /= 10;
//        }
//        return x == reverse;
//    }

    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) return false;
        int halfReverseX = 0;
        while (x > halfReverseX) {
            halfReverseX = halfReverseX * 10 + x % 10;
            x /= 10;
        }
        return halfReverseX == x || halfReverseX / 10 == x;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isPalindrome(-1));
        System.out.println(solution.isPalindrome(10010));

        System.out.println(solution.isPalindrome(0));
        System.out.println(solution.isPalindrome(11));
        System.out.println(solution.isPalindrome(111));
        System.out.println(solution.isPalindrome(222222222));
    }
}
