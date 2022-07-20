package com.hzf.leetcode._0009;

/**
 * 9. 回文数
 * 给你一个整数 x ，如果 x 是一个回文整数，返回 true ；否则，返回 false 。
 * 回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * 例如，121 是回文，而 123 不是。
 * <p>
 * 提示：
 * -231 <= x <= 231 - 1
 *
 * <a href="https://leetcode.cn/problems/regular-expression-matching/">...</a>
 */
public class Solution {


    public static void main(String[] args) {

        System.out.println(new Solution().isPalindrome(121));
    }


    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int num1 = 0;
        int num2 = x;
        while (x > 0) {
            int a = x % 10;
            num1 = num1 * 10 + a;
            x = x / 10;
        }
        return num1 == num2;
    }

}
