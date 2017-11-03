package com.blankj.hard._068;

import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/11/01
 *     desc  :
 * </pre>
 */
public class Solution {

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fullJustify(new String[]{"This", "is", "an", "example", "of", "text", "justification."}, 16));
    }
}
