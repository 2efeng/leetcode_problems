package com.hzf.leetcode._0042_x;

/**
 * 42. 接雨水（困难）
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * <p>
 * 提示：
 * n == height.length
 * 1 <= n <= 2 * 104
 * 0 <= height[i] <= 105
 *
 * <a href="https://leetcode.cn/problems/trapping-rain-water/">...</a>
 */
public class Solution {


    public static void main(String[] args) {
        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    public int trap(int[] height) {
        int rain = 0;
        boolean[][] dp = new boolean[height.length][106];
        boolean isTop = false;
        int index = 1;

        return rain;
    }

    /* (x,y)  */
//    private int trap(int[] height, int x, int y, int[][] dp) {
//
//
//    }

}
