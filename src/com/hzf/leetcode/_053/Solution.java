package com.hzf.leetcode._053;

import java.util.Map;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 子数组 是数组中的一个连续部分。
 * <p>
 * 提示：
 * 1 <= nums.length <= 105
 * -104 <= nums[i] <= 104
 * <p>
 * 进阶：如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的 分治法 求解。
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
//        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
//        System.out.println(solution.maxSubArray(new int[]{1}));
//        System.out.println(solution.maxSubArray(new int[]{5, 4, -1, 7, 8}));
//        System.out.println(solution.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
        System.out.println(solution.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }


    public int maxSubArray(int[] nums) {
//        return maxSum(nums, 0) ;
        int a = nums[0] + maxSum(nums, 1);
        int b = maxSum(nums, 1);
        return Math.max(a, b);
    }


    public int maxSum(int[] nums, int index) {
        if (index >= nums.length) return 0;
        int a = maxSum(nums, index + 1);
        int b = nums[index] + maxSum(nums, index + 1);
        return Math.max(a, b);
    }


}
