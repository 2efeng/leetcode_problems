package com.hzf.leetcode._0053;

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
 *
 * <a href="https://leetcode.cn/problems/maximum-subarray/">...</a>
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxSubArray3(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(solution.maxSubArray3(new int[]{1}));
        System.out.println(solution.maxSubArray3(new int[]{5, 4, -1, 7, 8}));
        System.out.println(solution.maxSubArray3(new int[]{-1, -2}));
    }


    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, maxSum(nums, i, dp));
        }
        return max;
    }


    public int maxSum(int[] nums, int index, int[] dp) {
        if (index >= nums.length) return 0;
        if (dp[index] != 0) return dp[index];
        int a = nums[index];
        int b = nums[index] + maxSum(nums, index + 1, dp);
        dp[index] = Math.max(a, b);
        return dp[index];
    }


    public int maxSubArray2(int[] nums) {
        int tempSum = nums[0], maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (tempSum > 0) tempSum += nums[i];
            else tempSum = nums[i];
            maxSum = Math.max(maxSum, tempSum);
        }
        return maxSum;
    }


    public int maxSubArray3(int[] nums) {
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] = nums[i - 1] + nums[i];
            }
            max = Math.max(max, nums[i]);
        }
        return max;
    }

}
