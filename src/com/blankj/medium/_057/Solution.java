package com.blankj.medium._057;

import com.blankj.structure.Interval;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/10/24
 *     desc  :
 * </pre>
 */
public class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        if (intervals.isEmpty()) return Collections.singletonList(newInterval);
        List<Interval> ans = new ArrayList<>();
        int i = 0, len = intervals.size();
        for (; i < len; ++i) {
            Interval interval = intervals.get(i);
            if (interval.end < newInterval.start) ans.add(interval);
            else break;
        }
        for (; i < len; ++i) {
            Interval interval = intervals.get(i);
            if (interval.start <= newInterval.end) {
                newInterval.start = Math.min(newInterval.start, interval.start);
                newInterval.end = Math.max(newInterval.end, interval.end);
            } else break;
        }
        ans.add(newInterval);
        for (; i < len; ++i) {
            ans.add(intervals.get(i));
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        Interval.print(solution.insert(Interval.createTestData("[1,3],[6,9]"), new Interval(2, 5)));
        Interval.print(solution.insert(Interval.createTestData("[1,2],[3,5],[6,7],[8,10],[12,16]"), new Interval(4, 9)));
    }
}
