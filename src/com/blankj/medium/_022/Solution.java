package com.blankj.medium._022;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/30
 *     desc  :
 * </pre>
 */
public class Solution {
//    public List<String> generateParenthesis(int n) {
//        List<String> list = new ArrayList<>();
//        helper(list, "", 0, n);
//        return list;
//    }
//
//    private void helper(List<String> list, String str, int rightNeed, int leftRest) {
//        if (rightNeed == 0 && leftRest == 0) {
//            list.add(str);
//            return;
//        }
//        if (rightNeed > 0) helper(list, str + ")", rightNeed - 1, leftRest);
//        if (leftRest > 0) helper(list, str + "(", rightNeed + 1, leftRest - 1);
//    }

    public List<String> generateParenthesis(int n) {
        HashMap<Integer, List<String>> hashMap = new HashMap<>();
        hashMap.put(0, Collections.singletonList(""));
        for (int i = 1; i <= n; i++) {
            List<String> list = new ArrayList<>();
            for (int j = 0; j < i; j++) {
                for (String fj : hashMap.get(j)) {
                    for (String fi_j_1 : hashMap.get(i - j - 1)) {
                        list.add("(" + fj + ")" + fi_j_1);// calculate f(i)
                    }
                }
            }
            hashMap.put(i, list);
        }
        return hashMap.get(n);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}
