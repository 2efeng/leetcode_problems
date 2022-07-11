package com.hzf.leetcode._088;


import java.util.Arrays;

/**
 * merge sorted array
 * 88. 合并两个有序数组（简单）
 * <p>
 * 给你两个按 非递减顺序 排列的整数数组nums1 和 nums2，另有两个整数 m 和 n ，分别表示 nums1 和 nums2 中的元素数目。
 * 请你 合并 nums2 到 nums1 中，使合并后的数组同样按 非递减顺序 排列。
 * 注意：最终，合并后数组不应由函数返回，而是存储在数组 nums1 中。为了应对这种情况，nums1 的初始长度为 m + n，其中前 m 个元素表示应合并的元素，后 n 个元素为 0 ，应忽略。nums2 的长度为 n 。
 * <p>
 * 提示：
 * nums1.length == m + n
 * nums2.length == n
 * 0 <= m, n <= 200
 * 1 <= m + n <= 200
 * -109 <= nums1[i], nums2[j] <= 109
 * <p>
 * 进阶：你可以设计实现一个时间复杂度为 O(m + n) 的算法解决此问题吗？
 * <p>
 * 链接：https://leetcode.cn/problems/merge-sorted-array
 */
public class Solution {


    public static void main(String[] args) {

    }


    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        if (m == 0) {
            System.arraycopy(nums2, 0, nums1, 0, nums2.length);
            return;
        }
        int left = m - 1;
        int right = n - 1;
        int index = m + n - 1;
        while (left > -1 || right > -1) {
            if (left == -1) {
                nums1[index--] = nums2[right--];
                continue;
            }
            if (right == -1) {
                nums1[index--] = nums1[left--];
                continue;
            }
            if (nums1[left] > nums2[right]) {
                nums1[index--] = nums1[left--];
            } else {
                nums1[index--] = nums2[right--];
            }
        }
    }

    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        //for (int i = 0; i != n; ++i) {
        //    nums1[m + i] = nums2[i];
        //}
        System.arraycopy(nums2, 0, nums1, m, nums2.length);
        Arrays.sort(nums1);
    }


    //原理
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
