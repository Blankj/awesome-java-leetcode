# [Text Justification][title]

## Description

Given an array of words and a width *maxWidth*, format the text such that each line has exactly *maxWidth* characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces `' '` when necessary so that each line has exactly *maxWidth* characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no **extra** space is inserted between words.

**Note:**

- A word is defined as a character sequence consisting of non-space characters only.
- Each word's length is guaranteed to be greater than 0 and not exceed *maxWidth*.
- The input array `words` contains at least one word.

**Example 1:**

```
Input:
words = ["This", "is", "an", "example", "of", "text", "justification."]
maxWidth = 16
Output:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
```

**Example 2:**

```
Input:
words = ["What","must","be","acknowledgment","shall","be"]
maxWidth = 16
Output:
[
  "What   must   be",
  "acknowledgment  ",
  "shall be        "
]
Explanation: Note that the last line is "shall be    " instead of "shall     be",
             because the last line must be left-justified instead of fully-justified.
             Note that the second line is also left-justified becase it contains only one word.
```

**Example 3:**

```
Input:
words = ["Science","is","what","we","understand","well","enough","to","explain",
         "to","a","computer.","Art","is","everything","else","we","do"]
maxWidth = 20
Output:
[
  "Science  is  what we",
  "understand      well",
  "enough to explain to",
  "a  computer.  Art is",
  "everything  else  we",
  "do                  "
]
```

**Tags:** String


## 思路

题意是给你一组单词和最大行宽，让你对齐他们，对齐的规则就是尽可能一行可以放下足够多的单词，如果最后有多余的空格，那就把空格均匀地插入到单词之间，如果不能平分的话，那就从左开始依次多插一个空格，最后一行单词之间就正常地一个空格即可，如果凑不到最大行宽，那就在末尾补充空格即可，描述地比较差，不懂的话其实看看 demo 也就懂了哈。题还是比较坑的，毕竟踩的比赞的人多，我也是靠模拟老老实实做出来的，求出可以最多插入空格数，然后用它除以可以插入的槽数获取每个单词之间的空格，它两取余的话就是最面需要多插入一个空格的个数，最后一行的话就单独处理即可。

```java
class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        int len = words.length;
        List<String> ans = new ArrayList<>();
        StringBuilder spaces = new StringBuilder();
        for (int i = 0; i < maxWidth; ++i) {
            spaces.append(" ");
        }
        int curLen = -1, start = 0;
        for (int i = 0; i < len; ++i) {
            if (curLen + words[i].length() + 1 <= maxWidth) {
                curLen += words[i].length() + 1;
            } else {
                StringBuilder sub = new StringBuilder(words[start]);
                int rest = maxWidth - curLen;
                int l = i - start - 1;
                if (l <= 0) {
                    sub.append(spaces.substring(0, rest));
                } else {
                    int m = rest / l + 1;
                    int mod = rest % l;
                    for (int j = start + 1; j < i; ++j) {
                        if (mod-- > 0) {
                            sub.append(spaces.substring(0, m + 1)).append(words[j]);
                        } else {
                            sub.append(spaces.substring(0, m)).append(words[j]);
                        }
                    }
                }
                ans.add(sub.toString());
                start = i;
                curLen = words[i].length();
            }
        }
        StringBuilder sub = new StringBuilder(words[start]);
        for (int i = start + 1; i < len; ++i) {
            sub.append(" ").append(words[i]);
        }
        ans.add(sub + spaces.substring(0, maxWidth - sub.length()));
        return ans;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/text-justification
[ajl]: https://github.com/Blankj/awesome-java-leetcode
