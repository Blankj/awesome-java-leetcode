# [长度最小的子数组][title]

## 题目描述

给定一个含有 **n** 个正整数的数组和一个正整数 **s** ，找出该数组中满足其和 **≥ s** 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。

**示例：**

```
输入：s = 7, nums = [2,3,1,2,4,3]
输出：2
解释：子数组 [4,3] 是该条件下的长度最小的连续子数组。
```

**进阶：**

* 如果你已经完成了 _O_(_n_) 时间复杂度的解法, 请尝试 _O_(_n_ log _n_) 时间复杂度的解法。

**标签：** 数组、双指针、二分查找


## 思路 0

直接暴力法，两重 for 循环，记录最小长度即可，代码很简单，如下所示：


```java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= s) {
                return 1;
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= s) {
                    ans = Math.min(ans, j - i + 1);
                    break;
                }
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```

## 思路 1

对上面进行优化，我们通过首位两个指针来模拟滑动窗口，如果加起来值小于 s，则向右扩大窗口直至不小于 s，然后固定窗口右侧来向左缩小窗口，同时更新符合条件的最小窗口长度即可，代码如下所示：

```java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;
        while (right < nums.length) {
            sum += nums[right++]; // 向右扩大窗口
            while (sum >= s) { // 如果不小于 s，则收缩窗口左边界
                ans = Math.min(ans, right - left);// 更新结果
                sum -= nums[left++]; // 向左缩小窗口
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```

## 思路 2

进阶中说了，尝试使用 O(nlogn) 时间复杂度的解法，由于数组都是正整数构成，所以前缀和一定是递增的，想到的应该就是用二分查找了，可以用 sums 数组来存储 nums 数组的前缀和，sums[i] 代表 nums[0] 到 nums[i - 1] 总和，然后遍历 sums 数组，对 sums[i] + s 进行二分查找然后不断更新结果即可，具体代码如下所示：


```java
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        int ans = Integer.MAX_VALUE;
        int[] sums = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            int target = s + sums[i]; // 确定要搜索的目标值
            // Java 二分查找 Arrays.binarySearch 如果找到就会返回该元素的索引；
            // 如果没找到就会返回一个负数，这个负数取反之后再减一就是查找的值应该在数组中的位置；
            // 例如 [-1, 0, 1, 5] 中二分查找 2，其返回值就是 -4，其 -(-4) - 1 = 3，所以 2 这个元素插入到数组的索引就是 3
            int bound = Arrays.binarySearch(sums, target);
            if (bound < 0) {
                bound = -bound - 1;
            }
            if (bound < sums.length) { // 当 bound 确定插入点不在 sums 数组的最后面时，说明不小于 target 的值了
                ans = Math.min(ans, bound - i);
            }
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
```

## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode-cn.com/problems/minimum-size-subarray-sum
[ajl]: https://github.com/Blankj/awesome-java-leetcode
