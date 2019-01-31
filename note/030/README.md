# [Substring with Concatenation of All Words][title]

## Description

You are given a string, **s**, and a list of words, **words**, that are all of the same length. Find all starting indices of substring(s) in **s** that is a concatenation of each word in **words** exactly once and without any intervening characters.

**Example 1:**

```
Input:
  s = "barfoothefoobarman",
  words = ["foo","bar"]
Output: [0,9]
Explanation: Substrings starting at index 0 and 9 are "barfoor" and "foobar" respectively.
The output order does not matter, returning [9,0] is fine too.
```

**Example 2:**

```
Input:
  s = "wordgoodgoodgoodbestword",
  words = ["word","good","best","word"]
Output: []
```

**Tags:** Hash Table, Two Pointers, String


## 思路

题意是给一个字符串 `s` 和等长度的单词数组 `words`，我们要找到的就是在 `s` 串中由所有单词组成的子串的索引（不要求顺序），不明白的话看下例子也就理解了，比如例子 1 的结果 [0, 9]：[`barfoo`,`foobar`] 就是符合的子串。

我们把 `words` 每个单词出现的次数都存入到一个 `map` 中，然后遍历 `s` 串，依次截取单词长度的子串做比较，如果都符合那就加入结果，如果不符合，我们要把和它相关联的不符合的都剔除掉，这样在之后的遍历就可以跳过该位置从而达到优化的目的。

```java
public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        if (s == null) return Collections.emptyList();
        int len = s.length();
        if (len == 0) return Collections.emptyList();
        int wordsSize = words.length;
        if (wordsSize == 0) return Collections.emptyList();
        int wordLen = words[0].length(), end = len - wordsSize * wordLen;
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
                if (cur + wordLen > len) break;
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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/substring-with-concatenation-of-all-words
[ajl]: https://github.com/Blankj/awesome-java-leetcode
