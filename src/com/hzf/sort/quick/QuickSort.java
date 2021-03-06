package com.hzf.sort.quick;

import java.util.Arrays;

/**
 * 快速排序
 *
 * 详细讲解 ：<a href="https://blog.csdn.net/weixin_43586713/article/details/119820797">...</a>
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {11, 24, 5, 32, 50, 34, 54, 76};
        System.out.println("快速排序前:" + Arrays.toString(nums));
        quickSort(nums, 0, nums.length - 1);
        System.out.println("快速排序后:" + Arrays.toString(nums));
    }

    public static void quickSort(int[] nums, int start, int end) {
        if (start > end) return;
        int i, j, base;
        i = start;
        j = end;
        base = nums[start];
        while (i < j) {
            while (i < j && nums[j] >= base) j--;
            while (i < j && nums[i] <= base) i++;
            if (i < j) {
                swap(nums, i, j);
            }
        }
        swap(nums, start, i);
        quickSort(nums, start, j - 1);
        quickSort(nums, j + 1, end);
    }

    public static void swap(int[] nums, int left, int right) {
        int temp = nums[left];
        nums[left] = nums[right];
        nums[right] = temp;
    }


}
