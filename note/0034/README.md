# [Find First and Last Position of Element in Sorted Array][title]

## Description

Given an array of integers `nums` sorted in non-decreasing order, find the starting and ending position of a given `target` value. If `target` is not found in the array, return `[-1, -1]`. You must write an algorithm with `O(log n)` runtime complexity.

**Example 1:**
```
Input: nums = [5,7,7,8,8,10], target = 8
Output: [3,4]
```

**Example 2:**
```
Input: nums = [5,7,7,8,8,10], target = 6
Output: [-1,-1]
```

**Tags:** Array, Binary Search

## Solution 0 - Binary Search

Run two binary searches: one to find the leftmost position and one to find the rightmost position of target.

```java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        return new int[]{findFirst(nums, target), findLast(nums, target)};
    }

    private int findFirst(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                result = mid;
                hi = mid - 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }

    private int findLast(int[] nums, int target) {
        int lo = 0, hi = nums.length - 1, result = -1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] == target) {
                result = mid;
                lo = mid + 1;
            } else if (nums[mid] < target) {
                lo = mid + 1;
            } else {
                hi = mid - 1;
            }
        }
        return result;
    }
}
```

[title]: https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array
