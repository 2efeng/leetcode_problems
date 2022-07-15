//package com.hzf.leetcode._042;
//
///**
// * 42. 接雨水（困难）
// * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
// * <p>
// * 提示：
// * n == height.length
// * 1 <= n <= 2 * 104
// * 0 <= height[i] <= 105
// *
// * <a href="https://leetcode.cn/problems/trapping-rain-water/">...</a>
// */
//public class Solution {
//
//
//    public static void main(String[] args) {
//        System.out.println(new Solution().trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
//    }
//
//    public int trap(int[] height) {
//        int rain = 0;
//        boolean[][] dp = new boolean[height.length][106];
//
//        for (int i = 1; i < height.length; i++) {
//            int currRain = 0;
//            int he = 0;
//            while (currRain != -1) {
//
//
//                if (currRain > 0) rain += currRain;
//            }
//        }
//        return rain;
//    }
//
//    /*
//     * -1：数组，1：水 ，0：空,-2是有数
//     * (x,y)
//     * x-1 => -1,1
//     * x+1 => -1,1
//     */
//    private boolean trapDP(int[] height, int x, int y, int[][] dp) {
//        if (x == height.length - 1) return -1;
//        if (height[x] >= y) return 0;
//        if (dp[x][y] == 1) return 1;
//
//        boolean left = height[x - 1] >= y || trapDP(height, x - 1, y, dp) == 1;
//        boolean right = height[x + 1] >= y || trapDP(height, x + 1, y, dp) == 1;
//
//
//        return dp[x][y];
//    }
//
//
//}
