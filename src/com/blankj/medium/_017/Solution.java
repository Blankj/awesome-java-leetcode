package com.blankj.medium._017;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/15
 *     desc  :
 * </pre>
 */
public class Solution {
//    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
//
//    public List<String> letterCombinations(String digits) {
//        if (digits.length() == 0) return Collections.emptyList();
//        List<String> list = new ArrayList<>();
//        helper(list, digits, "");
//        return list;
//    }
//
//    private void helper(List<String> list, String digits, String ans) {
//        if (ans.length() == digits.length()) {
//            list.add(ans);
//            return;
//        }
//        for (char c : map[digits.charAt(ans.length()) - '2'].toCharArray()) {
//            helper(list, digits, ans + c);
//        }
//    }

    private static String[] map = new String[]{"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) return Collections.emptyList();
        LinkedList<String> list = new LinkedList<>();
        list.add("");
        char[] charArray = digits.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            char c = charArray[i];

            while (list.getFirst().length() == i) {
                String pop = list.removeFirst();
                for (char v : map[c - '2'].toCharArray()) {
                    list.addLast(pop + v);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("23"));
    }
}