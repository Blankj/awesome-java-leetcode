package com.blankj.easy._067;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/07
 *     desc  :
 * </pre>
 */
public class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
        while (p1 >= 0 && p2 >= 0) {
            carry += a.charAt(p1--) - '0';
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p1 >= 0) {
            carry += a.charAt(p1--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        while (p2 >= 0) {
            carry += b.charAt(p2--) - '0';
            sb.insert(0, (char) (carry % 2 + '0'));
            carry >>= 1;
        }
        if (carry == 1) {
            sb.insert(0, '1');
        }
        return sb.toString();
    }

//    public String addBinary(String a, String b) {
//        StringBuilder sb = new StringBuilder();
//        int carry = 0, p1 = a.length() - 1, p2 = b.length() - 1;
//        while (p1 >= 0 || p2 >= 0 || carry == 1) {
//            carry += p1 >= 0 ? a.charAt(p1--) - '0' : 0;
//            carry += p2 >= 0 ? b.charAt(p2--) - '0' : 0;
//            sb.insert(0, (char) (carry % 2 + '0'));
//            carry >>= 1;
//        }
//        return sb.print();
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("11", "1"));
    }
}
