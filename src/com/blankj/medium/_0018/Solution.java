package com.blankj.medium._018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * <pre>
 *     author: Blankj
 *     blog  : http://blankj.com
 *     time  : 2018/01/30
 *     desc  :
 * </pre>
 */
public class Solution {
//    public List<List<Integer>> fourSum(int[] nums, int target) {
//        List<List<Integer>> res = new ArrayList<>();
//        int len = nums.length;
//        if (len < 4) return res;
//        Arrays.sort(nums);
//        int max = nums[len - 1];
//        if (4 * max < target) return res;
//        for (int i = 0; i < len - 3;) {
//            if (nums[i] * 4 > target) break;
//            if (nums[i] + 3 * max < target) {
//                while (nums[i] == nums[++i] && i < len - 3) ;
//                continue;
//            }
//
//            for (int j = i + 1; j < len - 2;) {
//                int subSum = nums[i] + nums[j];
//                if (nums[i] + nums[j] * 3 > target) break;
//                if (subSum + 2 * max < target) {
//                    while (nums[j] == nums[++j] && j < len - 2) ;
//                    continue;
//                }
//
//                int left = j + 1, right = len - 1;
//                while (left < right) {
//                    int sum = subSum + nums[left] + nums[right];
//                    if (sum == target) {
//                        res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
//                        while (nums[left] == nums[++left] && left < right);
//                        while (nums[right] == nums[--right] && left < right);
//                    } else if (sum < target) ++left;
//                    else --right;
//                }
//                while (nums[j] == nums[++j] && j < len - 2) ;
//            }
//            while (nums[i] == nums[++i] && i < len - 3) ;
//        }
//        return res;
//    }

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.fourSum(new int[]{1, 0, -1, 0, -2, 2}, 0));
    }
}
