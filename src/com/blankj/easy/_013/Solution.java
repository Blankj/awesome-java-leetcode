package com.blankj.easy._013;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/25
 *     desc  :
 * </pre>
 */
public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int len = s.length();
        int sum = map.get(s.charAt(len - 1));
        for (int i = len - 2; i >= 0; --i) {
            if (map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
                sum -= map.get(s.charAt(i));
            } else {
                sum += map.get(s.charAt(i));
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.romanToInt("DCXXI"));// 621
        System.out.println(solution.romanToInt("CCCXLVIII"));// 348
    }
}
