# [Insert Interval][title]

## Description

Given a set of *non-overlapping* intervals, insert a new interval into the intervals (merge if necessary).

You may assume that the intervals were initially sorted according to their start times.

**Example 1:**

```
Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
Output: [[1,5],[6,9]]
```

**Example 2:**

```
Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
Output: [[1,2],[3,10],[12,16]]
Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
```

**Tags:** Array, Sort


## 思路

题意是给你一组有序区间，和一个待插入区间，让你待插入区间插入到前面的区间中，我们分三步走：

1. 首先把有序区间中小于待插入区间的部分加入到结果中；

2. 其次是插入待插入区间，如果有交集的话取两者交集的端点值；

3. 最后把有序区间中大于待插入区间的部分加入到结果中；

```java
/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
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
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/insert-interval
[ajl]: https://github.com/Blankj/awesome-java-leetcode
