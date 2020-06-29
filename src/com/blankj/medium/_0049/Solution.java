package com.blankj.medium._049;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/18
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return Collections.emptyList();
        List<List<String>> list = new ArrayList<>();
        Map<String, Integer> hash = new HashMap<>();
        int i = 0;
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String sortStr = String.valueOf(c);
            if (!hash.containsKey(sortStr)) {
                hash.put(sortStr, i++);
                List<String> sub = new ArrayList<>();
                sub.add(str);
                list.add(sub);
            } else {
                list.get(hash.get(sortStr)).add(str);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
    }
}
