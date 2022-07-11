package com.hzf.leetcode._001;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/***
 * TwoSum
 * 1. 两数之和(简单)
 *
 * 给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 target 的那两个整数，并返回它们的数组下标。
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * 你可以按任意顺序返回答案。
 *
 * 提示：
 *      2 <= nums.length <= 104
 *      -109 <= nums[i] <= 109
 *      -109 <= target <= 109
 *      只会存在一个有效答案
 * 进阶：你可以想出一个时间复杂度小于 O(n2) 的算法吗？
 *
 * 链接：https://leetcode.cn/problems/two-sum
 */
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int temp = target - nums[i];
            if (numMap.containsKey(temp)) {
                return new int[]{numMap.get(temp), i};
            }
            numMap.put(nums[i], i);
        }
        return new int[]{0, 0};
    }



    public int[] twoSum1(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] + nums[i] == target) {
                    return new int[]{i, j};
                }
            }
        }
        return new int[]{0, 0};
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{2, 7, 11, 15}, 9))); //[0,1]
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 2, 4}, 6))); //[1,2]
        System.out.println(Arrays.toString(new Solution().twoSum(new int[]{3, 3}, 6))); //[0,1]
    }


}
