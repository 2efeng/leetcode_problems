package com.hzf.leetcode._005;

/**
 * 5. 最长回文子串（中等）
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 提示：
 * 1 <= s.length <= 1000
 * s 仅由数字和英文字母组成
 * <p>
 * 链接：https://leetcode.cn/problems/longest-palindromic-substring/
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babad"));//bab
        System.out.println(solution.longestPalindrome("cbbd"));//bb
        System.out.println(solution.longestPalindrome("xaabacxcabaaxcabaax"));//xaabacxcabaax
        System.out.println(solution.longestPalindrome("ccc"));//ccc
    }


    public String longestPalindrome(String s) {
        if (s.length() == 1) return s;
        int max = 0;
        String res = "";
        for (int i = 0; i < s.length() - 1; i++) {
            int currMax = 0;
            int left = i;
            int right = s.length() - 1;
            int index = right;
            while (left < index) {
                if (s.charAt(left) == s.charAt(index)) {
                    left++;
                    index--;
                    currMax += 2;
                } else {
                    if (left != i) {
                        left = i;
                        currMax = 0;
                    }
                    right--;
                    index = right;
                }
            }
            if (left == index) currMax += 1;
            if (currMax > max) {
                res = s.substring(i, right + 1);
                max = currMax;
            }
        }
        return res;
    }

    /**
     * 动态规划
     * 对于一个子串而言，如果它是回文串，并且长度大于 22，那么将它首尾的两个字母去除之后，它仍然是个回文串。
     */
    public String longestPalindrome2(String s) {
        if (s.length() == 1) return s;


        return "";
    }


    /**
     * 中心扩散
     */
    public String longestPalindrome3(String s) {
        if (s.length() == 1) return s;





        return "";
    }






}
