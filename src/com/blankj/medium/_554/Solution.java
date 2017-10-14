package com.blankj.medium._554;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/13
 *     desc  :
 * </pre>
 */
public class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int width = 0, max = 0;
        for (List<Integer> sub : wall) {
            int p = 0;
            for (int i = 0, len = sub.size() - 1; i < len; ++i) {
                p += sub.get(i);
                Integer v = map.get(p);
                map.put(p, (v == null ? 0 : v) + 1);
            }
        }
        for (Integer integer : map.values()) {
            if (integer > max) max = integer;
        }
        return wall.size() - max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> list = new ArrayList<>();
        list.add(Arrays.asList(1, 2, 2, 1));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 2));
        list.add(Arrays.asList(2, 4));
        list.add(Arrays.asList(3, 1, 2));
        list.add(Arrays.asList(1, 3, 1, 1));
        System.out.println(solution.leastBricks(list));
    }
}