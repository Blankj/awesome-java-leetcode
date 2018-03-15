package com.blankj.hard._030;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/02/01
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        int wordsSize = words.length, wordLen = words[0].length(), end = s.length() - wordsSize * wordLen;
        if (end < 0) return Collections.emptyList();
        Map<String, Integer> countMap = new HashMap<>();
        for (String word : words) {
            countMap.put(word, countMap.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        Set<Integer> ignores = new HashSet<>();
        for (int i = 0; i <= end; ++i) {
            if (ignores.contains(i)) continue;
            Map<String, Integer> findMap = new HashMap<>();
            int st = i, count = 0;
            List<Integer> ignore = new ArrayList<>();
            for (int j = 0; ; ++j) {
                int cur = i + j * wordLen;
                if (cur + wordLen > s.length()) break;
                String word = s.substring(cur, cur + wordLen);
                if (countMap.containsKey(word)) {
                    findMap.put(word, findMap.getOrDefault(word, 0) + 1);
                    ++count;
                    while (findMap.get(word) > countMap.get(word)) {
                        ignore.add(st);
                        String tmp = s.substring(st, st += wordLen);
                        findMap.put(tmp, findMap.get(tmp) - 1);
                        --count;
                    }
                    if (count == wordsSize) {
                        ignore.add(st);
                        res.add(st);
                        String tmp = s.substring(st, st += wordLen);
                        findMap.put(tmp, findMap.get(tmp) - 1);
                        --count;
                    }
                } else {
                    for (int k = i; k <= cur; k += wordLen) {
                        ignore.add(k);
                    }
                    break;
                }
            }
            ignores.addAll(ignore);
        }
        return res;
    }

//    public List<Integer> findSubstring(String S, String[] L) {
//        List<Integer> res = new LinkedList<>();
//        int N = S.length();
//        int M = L.length; // *** length
//        int wl = L[0].length();
//        Map<String, Integer> map = new HashMap<>(), curMap = new HashMap<>();
//        for (String s : L) {
//            if (map.containsKey(s)) map.put(s, map.get(s) + 1);
//            else map.put(s, 1);
//        }
//        String str = null, tmp = null;
//        for (int i = 0; i < wl; i++) {
//            int count = 0;  // remark: reset count
//            int start = i;
//            for (int r = i; r + wl <= N; r += wl) {
//                str = S.substring(r, r + wl);
//                if (map.containsKey(str)) {
//                    if (curMap.containsKey(str)) curMap.put(str, curMap.get(str) + 1);
//                    else curMap.put(str, 1);
//
//                    if (curMap.get(str) <= map.get(str)) count++;
//                    if (count == M) {
//                        res.add(start);
//                        tmp = S.substring(start, start + wl);
//                        curMap.put(tmp, curMap.get(tmp) - 1);
//                        start += wl;
//                        count--;
//                    }
//                    while (curMap.get(str) > map.get(str)) {
//                        tmp = S.substring(start, start + wl);
//                        curMap.put(tmp, curMap.get(tmp) - 1);
//                        start += wl;
//                        if (curMap.get(tmp) < map.get(tmp)) count--;
//
//                    }
//                } else {
//                    curMap.clear();
//                    count = 0;
//                    start = r + wl;
//                }
//            }
//            curMap.clear();
//        }
//        return res;
//    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "good"}));
        System.out.println(solution.findSubstring("barfoothefoobarman", new String[]{"foo", "bar"}));
        System.out.println(solution.findSubstring("barfoofoobarthefoobarman", new String[]{"bar", "foo", "the"}));
    }
}
