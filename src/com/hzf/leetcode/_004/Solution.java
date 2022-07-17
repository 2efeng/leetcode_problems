package com.hzf.leetcode._004;

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

        // 1.0
        System.out.println(solution.findMedianSortedArrays(new int[]{}, new int[]{1}));

        // 2.50000  合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
        System.out.println(solution.findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 7}));
    }

    //快速排序合并两个数组
    //第88题的合并数组


    //二分查找
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
        }

        int m = nums1.length;
        int n = nums2.length;
        int totalLeft = (m + n + 1) / 2;

        int left = 0;
        int right = m;

        //交叉比较 同时满足 nums1[i - 1] <= nums2[j] || nums2[j - 1] <= nums1[i]

        while (left < right) {
            int i = (right + left + 1) / 2;
            int j = totalLeft - i;
            //缩小区间
            if (nums1[i - 1] > nums2[j]) {
                //[left ,i-1]
                right = i - 1;
            } else {
                //[i, right]
                left = i;
            }

        }

        int i = left;
        int j = totalLeft - i;

        int nums1LeftMax = i == 0 ? Integer.MIN_VALUE : nums1[i - 1];
        int nums1RightMin = i == m ? Integer.MAX_VALUE : nums1[i];
        int nums2LeftMax = j == 0 ? Integer.MIN_VALUE : nums2[j - 1];
        int nums2RightMin = j == n ? Integer.MAX_VALUE : nums2[j];
        if ((m + n) % 2 == 1) {
            return Math.max(nums1LeftMax, nums2LeftMax);
        }
        return (double) (Math.max(nums1LeftMax, nums2LeftMax) + Math.min(nums1RightMin, nums2RightMin)) / 2;
    }


    //合并有序数组
    public int[] mergeArr(int[] nums1, int[] nums2) {
        if (nums1.length == 0) return nums2;
        if (nums2.length == 0) return nums1;
        int[] res = new int[nums1.length + nums2.length];
        int left = nums1.length - 1;
        int right = nums2.length - 1;
        int index = res.length - 1;
        while (left > -1 || right > -1) {
            if (left == -1) {
                res[index--] = nums2[right--];
                continue;
            }
            if (right == -1) {
                res[index--] = nums1[left--];
                continue;
            }
            if (nums1[left] > nums2[right]) {
                res[index--] = nums1[left--];
            } else {
                res[index--] = nums2[right--];
            }
        }
        return res;
    }


}
