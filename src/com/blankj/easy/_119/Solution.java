package com.blankj.easy._119;


import java.util.ArrayList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/11
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i <= rowIndex; ++i) {
            res.add(1);
            for (int j = i - 1; j > 0; --j) {
                res.set(j, res.get(j - 1) + res.get(j));
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow(5));
    }
}
