package com.blankj.easy._035;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/05/02
 *     desc  :
 * </pre>
 */
public class Solution {
    public int searchInsert(int[] nums, int target) {
        int left = 0, right = nums.length - 1, mid = (right + left) >> 1;
        while (left <= right) {
            if (target <= nums[mid]) right = mid - 1;
            else left = mid + 1;
            mid = (right + left) >> 1;
        }
        return left;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 7));
        System.out.println(solution.searchInsert(nums, 0));
    }
}
