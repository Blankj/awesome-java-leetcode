package com.blankj.medium._056;

import com.blankj.structure.Interval;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/19
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) return intervals;
        intervals.sort(new Comparator<Interval>() {
            @Override
            public int compare(Interval o1, Interval o2) {
                if (o1.start < o2.start) return -1;
                if (o1.start > o2.start) return 1;
                return 0;
            }
        });
        List<Interval> ans = new ArrayList<>();
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        for (Interval interval : intervals) {
            if (interval.start <= end) {
                end = Math.max(end, interval.end);
            } else {
                ans.add(new Interval(start, end));
                start = interval.start;
                end = interval.end;
            }
        }
        ans.add(new Interval(start, end));
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval.print(solution.merge(Interval.createTestData("[1,3],[2,6],[8,10],[15,18]")));
    }
}
