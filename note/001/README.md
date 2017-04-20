# [Two Sum](https://leetcode.com/problems/two-sum/)

## Description

Given an array of integers, return **indices** of the two numbers such that they add up to a specific target.

You may assume that each input would have ***exactly*** one solution, and you may not use the same element twice.

**Example:**

```
Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].
```

**Tags：** Array, Hash Table


## 思路0

题意是让你从给定的数组中找到两个元素的和为指定值的两个索引，最容易的当然是循环两次，复杂度为`O(n^2)`，首次提交居然是2ms，打败了100%的提交，谜一样的结果，之后再次提交就再也没跑到过2ms了。

``` java
public class Solution {
    public int[] twoSum(int[] nums, int target) {
        int st = 0, end = nums.length;
        for (int i = 0; i < end; ++i) {
            for (int j = i + 1; j < end; ++j) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}
```


## 思路1

利用HashMap作为存储，键为目标值减去当前元素值，索引为值，比如`i = 0`时，此时首先要判断`nums[0] = 2`是否在map中，如果不存在，那么插入键值对`key = 9 - 2 = 7, value = 0`，之后当`i = 1`时，此时判断`nums[1] = 7`已存在于map中，那么取出该`value = 0`作为第一个返回值，当前`i`作为第二个返回值，具体代码如下所示。

``` java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        int len = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; ++i) {
            if (map.containsKey(nums[i])) {
                return new int[]{map.get(nums[i]), i};
            }
            map.put(target - nums[i], i);
        }
        return null;
    }
}
```
