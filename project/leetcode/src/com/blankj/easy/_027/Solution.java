package com.blankj.easy._027;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2017/04/31
 *     desc  :
 * </pre>
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int tail = 0;
        for (int i = 0, len = nums.length; i < len; ++i) {
            if (nums[i] != val) {
                nums[tail++] = nums[i];
            }
        }
        return tail;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] data = new int[]{0, 3, 1, 1, 2, 3, 3, 3};
        int len = solution.removeElement(data, 3);
        for (int i = 0; i < len; i++) {
            System.out.print(data[i] + (i == len - 1 ? "" : ", "));
        }
    }
}
