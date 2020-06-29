# [4Sum][title]

## Description

Given an array `nums` of *n* integers and an integer `target`, are there elements *a*, *b*, *c*, and *d* in `nums` such that *a* + *b* + *c* + *d* = `target`? Find all unique quadruplets in the array which gives the sum of `target`.

**Note:**

The solution set must not contain duplicate quadruplets.

**Example:**

```
Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.

A solution set is:
[
  [-1,  0, 0, 1],
  [-2, -1, 1, 2],
  [-2,  0, 0, 2]
]
```

**Tags:** Array, Hash Table, Two Pointers


## 思路 0

题意是让你从数组中找出所有四个数的和为 `target` 的元素构成的非重复序列，该题和 [3Sum][015] 的思路基本一样，先对数组进行排序，然后遍历这个排序数组，因为这次是四个元素的和，所以外层需要两重循环，然后还是用两个指针分别指向当前元素的下一个和数组尾部，判断四者的和与 `target` 的大小来移动两个指针，其中细节操作还是优化和去重。

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        int len = nums.length;
        if (len < 4) return res;
        Arrays.sort(nums);
        int max = nums[len - 1];
        if (4 * max < target) return res;
        for (int i = 0; i < len - 3;) {
            if (nums[i] * 4 > target) break;
            if (nums[i] + 3 * max < target) {
                while (nums[i] == nums[++i] && i < len - 3) ;
                continue;
            }

            for (int j = i + 1; j < len - 2;) {
                int subSum = nums[i] + nums[j];
                if (nums[i] + nums[j] * 3 > target) break;
                if (subSum + 2 * max < target) {
                    while (nums[j] == nums[++j] && j < len - 2) ;
                    continue;
                }

                int left = j + 1, right = len - 1;
                while (left < right) {
                    int sum = subSum + nums[left] + nums[right];
                    if (sum == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                        while (nums[left] == nums[++left] && left < right);
                        while (nums[right] == nums[--right] && left < right);
                    } else if (sum < target) ++left;
                    else --right;
                }
                while (nums[j] == nums[++j] && j < len - 2) ;
            }
            while (nums[i] == nums[++i] && i < len - 3) ;
        }
        return res;
    }
}
```


## 思路 1

从 [Two Sum][001]、[3Sum][015] 到现在的 4Sum，其实都是把高阶降为低阶，那么我们就可以写出 kSum 的函数来对其进行降阶处理，降到 2Sum 后那么我们就可以对其进行最后的判断了，代码如下所示，其也做了相应的优化和去重。

```java
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        int len = nums.length;
        if (len < 4) return Collections.emptyList();
        int max = nums[len - 1];
        if (4 * max < target) return Collections.emptyList();
        return kSum(nums, 0, 4, target);
    }

    private List<List<Integer>> kSum(int[] nums, int start, int k, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (k == 2) {
            int left = start, right = nums.length - 1;
            while (left < right) {
                int sum = nums[left] + nums[right];
                if (sum == target) {
                    List<Integer> twoSum = new LinkedList<>();
                    twoSum.add(nums[left]);
                    twoSum.add(nums[right]);
                    res.add(twoSum);
                    while (nums[left] == nums[++left] && left < right) ;
                    while (nums[right] == nums[--right] && left < right) ;
                } else if (sum < target) ++left;
                else --right;
            }
        } else {
            int i = start, end = nums.length - (k - 1), max = nums[nums.length - 1];
            while (i < end) {
                if (nums[i] * k > target) return res;
                if (nums[i] + (k - 1) * max < target) {
                    while (nums[i] == nums[++i] && i < end) ;
                    continue;
                }
                List<List<Integer>> temp = kSum(nums, i + 1, k - 1, target - nums[i]);
                for (List<Integer> t : temp) {
                    t.add(0, nums[i]);
                }
                res.addAll(temp);
                while (nums[i] == nums[++i] && i < end) ;
            }
        }
        return res;
    }
}
```



## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[001]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/001/README.md
[015]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/015/README.md
[title]: https://leetcode.com/problems/4sum
[ajl]: https://github.com/Blankj/awesome-java-leetcode
