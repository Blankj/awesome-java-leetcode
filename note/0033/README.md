# [Search in Rotated Sorted Array][title]

## Description

Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., `[0,1,2,4,5,6,7]` might become `[4,5,6,7,0,1,2]`).

You are given a target value to search. If found in the array return its index, otherwise return `-1`.

You may assume no duplicate exists in the array.

Your algorithm's runtime complexity must be in the order of *O*(log *n*).

**Example 1:**

```
Input: nums = [4,5,6,7,0,1,2], target = 0
Output: 4
```

**Example 2:**

```
Input: nums = [4,5,6,7,0,1,2], target = 3
Output: -1
```

**Tags:** Arrays, Binary Search


## 思路

题意是让你从一个旋转过后的递增序列中寻找给定值，找到返回索引，找不到返回-1，我们在下面这组数据中寻找规律。

```
1 2 4 5 6 7 0
2 4 5 6 7 0 1
4 5 6 7 0 1 2
5 6 7 0 1 2 4
6 7 0 1 2 4 5
7 0 1 2 4 5 6
```

由于是旋转一次，所以肯定有一半及以上的序列仍然是具有递增性质的，我们观察到如果中间的数比左面的数大的话，那么左半部分序列是递增的，否则右半部分就是递增的，那么我们就可以确定给定值是否在递增序列中，从而决定取舍哪半边。


```java
class Solution {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1, mid;
        while (l <= r) {
            mid = l + r >>> 1;
            if (nums[mid] == target) return mid;
            else if (nums[mid] >= nums[l]) {
                if (nums[l] <= target && target < nums[mid]) r = mid - 1;
                else l = mid + 1;
            } else {
                if (nums[mid] < target && target <= nums[r]) l = mid + 1;
                else r = mid - 1;
            }
        }
        return -1;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/search-in-rotated-sorted-array
[ajl]: https://github.com/Blankj/awesome-java-leetcode
