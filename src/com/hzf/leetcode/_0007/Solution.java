package com.hzf.leetcode._0007;

/**
 * 7. 整数反转（中等）
 * 给你一个 32 位的有符号整数 x ，返回将 x 中的数字部分反转后的结果。
 * 如果反转后整数超过 32 位的有符号整数的范围 [−231,  231 − 1] ，就返回 0。
 * 假设环境不允许存储 64 位整数（有符号或无符号）。
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 * <p>
 * <a href="https://leetcode.cn/problems/reverse-integer"/>
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println(reverse(123) + " res:" + (reverse(123) == 321)); // 321
        System.out.println(reverse(-123) + " res:" + (reverse(-123) == -321)); // -321
        System.out.println(reverse(120) + " res:" + (reverse(120) == 21)); // 21
        System.out.println(reverse(0) + " res:" + (reverse(0) == 0)); // 0
        System.out.println(reverse(1534236469) + " res:" + (reverse(1534236469) == 0)); // 0

    }


    public static int reverse(int x) {

        int res = 0;
        while (x != 0) {
            if (res > (Math.pow(2, 31) - 1) / 10 || res < Math.pow(2, 31) / -10)
                return 0;
            int remainder = x % 10;
            res = res * 10 + remainder;
            x = x / 10;
        }
        return res;
    }

}
