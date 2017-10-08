package com.blankj.easy._038;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/03
 *     desc  :
 * </pre>
 */
public class Solution {
    public String countAndSay(int n) {
        String str = "1";
        while (--n > 0) {
            int times = 1;
            StringBuilder sb = new StringBuilder();
            char[] chars = str.toCharArray();
            int len = chars.length;
            for (int j = 1; j < len; j++) {
                if (chars[j - 1] == chars[j]) {
                    times++;
                } else {
                    sb.append(times).append(chars[j - 1]);
                    times = 1;
                }
            }
            str = sb.append(times).append(chars[len - 1]).toString();
        }
        return str;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 1; i < 6; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}
