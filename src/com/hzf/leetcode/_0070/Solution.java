package com.hzf.leetcode._0070;

/**
 * 70. 爬楼梯 （简单）
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * <p>
 * 提示：
 * 1 <= n <= 45
 *
 * <a href="https://leetcode.cn/problems/climbing-stairs/">...</a>
 */
public class Solution {


    public int climbStairs(int n) {
        int[] dp = new int[n];
        return climb(n - 1, dp) + climb(n - 2, dp);
    }


    public int climb(int n, int[] dp) {
        if (n < 0) return 0;
        if (n == 0) return 1;
        if (dp[n - 1] != 0) return dp[n - 1];
        dp[n - 1] = climb(n - 1, dp) + climb(n - 2, dp);
        return dp[n - 1];
    }

}
