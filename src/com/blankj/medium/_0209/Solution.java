package com.blankj.medium._0209;

import java.util.Arrays;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2020/06/30
 *     desc  :
 * </pre>
 */
public class Solution {
//    public int minSubArrayLen(int s, int[] nums) {
//        int ans = Integer.MAX_VALUE;
//        for (int i = 0; i < nums.length; i++) {
//            int sum = nums[i];
//            if (sum >= s) {
//                return 1;
//            }
//            for (int j = i + 1; j < nums.length; j++) {
//                sum += nums[j];
//                if (sum >= s) {
//                    ans = Math.min(ans, j - i + 1);
//                    break;
//                }
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

//    public int minSubArrayLen(int s, int[] nums) {
//        int left = 0, right = 0, sum = 0, ans = Integer.MAX_VALUE;
//        while (right < nums.length) {
//            sum += nums[right++]; // 向右扩大窗口
//            while (sum >= s) { // 如果不小于 s，则收缩窗口左边界
//                ans = Math.min(ans, right - left);// 更新结果
//                sum -= nums[left++]; // 向左缩小窗口
//            }
//        }
//        return ans == Integer.MAX_VALUE ? 0 : ans;
//    }

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }
}