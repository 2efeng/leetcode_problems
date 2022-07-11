package com.hzf._004;

/**
 * Median Of Two Sorted Arrays
 * 4. 寻找两个正序数组的中位数(困难)
 * <p>
 * 给定两个大小分别为 m 和 n 的正序（从小到大）数组nums1 和nums2。请你找出并返回这两个正序数组的 中位数 。
 * 算法的时间复杂度应该为 O(log (m+n)) 。
 * <p>
 * 提示：
 * nums1.length == m
 * nums2.length == n
 * 0 <= m <= 1000
 * 0 <= n <= 1000
 * 1 <= m + n <= 2000
 * -106 <= nums1[i], nums2[i] <= 106
 * <p>
 * <p>
 * 链接：https://leetcode.cn/problems/median-of-two-sorted-arrays
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();

        // 2.00000  合并数组 = [1,2,3] ，中位数 2
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));

        // 2.50000  合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 2}, new int[]{3, 4}));

        // 2.50000  合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));

        // 2.50000  合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double medianNum1 = 0, medianNum2 = 0;
        if (nums1.length % 2 == 0 && nums1.length != 0) {
            medianNum1 = (nums1[nums1.length / 2] + nums1[nums1.length / 2 - 1]) / 2.0;
        }
        if (nums1.length % 2 == 1) {
            medianNum1 = nums1[nums1.length / 2];
        }
        if (nums2.length % 2 == 0 && nums2.length != 0) {
            medianNum2 = (nums2[nums2.length / 2] + nums2[nums2.length / 2 - 1]) / 2.0;
        }
        if (nums2.length % 2 == 1) {
            medianNum2 = nums2[nums2.length / 2];
        }

        if (medianNum1 == 0) return medianNum2;
        if (medianNum2 == 0) return medianNum1;
        return (medianNum1 + medianNum2) / 2.0;
    }

}
