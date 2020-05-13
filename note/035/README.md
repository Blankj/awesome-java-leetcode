# [Search Insert Position][title]

## Description

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

**Example 1:**

```
Input: [1,3,5,6], 5
Output: 2
```

**Example 2:**

```
Input: [1,3,5,6], 2
Output: 1
```

**Example 3:**

```
Input: [1,3,5,6], 7
Output: 4
```

**Example 1:**

```
Input: [1,3,5,6], 0
Output: 0
```

**Tags:** Array, Binary Search


## 思路

题意是让你从一个没有重复元素的已排序数组中找到插入位置的索引。因为数组已排序，所以我们可以想到二分查找法，因为查找到的条件是找到第一个等于或者大于 `target` 的元素的位置，所以二分法略作变动即可。

```java
class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = left + (right - left) >> 1;
        while (left <= right) {
            if (target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
            mid = left + (right - left) >> 1;
        }
        return left;
    }
}
```

mid 说明：

有两种处理方法：
1. mid = (left + right) >> 1
2. mid = left + (right - left) >> 1

在一般情况下两种都可以。

但是当 left 和 right 接近于 int 的最大值时，**(left + right)** 可能发生类型溢出，因此推荐用第二种方式。

## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/search-insert-position
[ajl]: https://github.com/Blankj/awesome-java-leetcode
