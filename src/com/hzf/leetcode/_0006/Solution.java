package com.hzf.leetcode._0006;

/**
 * 6. Z 字形变换（中等）
 * 将一个给定字符串 s 根据给定的行数 numRows ，以从上往下、从左到右进行 Z 字形排列。
 *
 * https://leetcode.cn/problems/zigzag-conversion/
 */
public class Solution {


    public static void main(String[] args) {
        /*
            P   A   H   N
            A P L S I I G
            Y   I   R
         */
        System.out.println(convert("PAYPALISHIRING", 3) + ": " + convert("PAYPALISHIRING", 3).equals("PAHNAPLSIIGYIR"));//PAHNAPLSIIGYIR
        /*
            P     I    N
            A   L S  I G
            Y A   H R
            P     I
         */
        System.out.println(convert("PAYPALISHIRING", 4) + ": " + convert("PAYPALISHIRING", 4).equals("PINALSIGYAHRPI")); //PINALSIGYAHRPI

    }

    public static String convert(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;
        int t = numRows * 2 - 2;
        int c = (s.length() / t + 1) * (numRows - 1);
        char[][] chars = new char[numRows][c];
        int x = 0, y = 0;
        for (int i = 0; i < s.length(); i++) {
            chars[x][y] = s.charAt(i);
            if (i % t < numRows - 1) {// 向下移动
                x++;
            } else { // 向右上移动
                x--;
                y++;
            }
        }
        StringBuilder ans = new StringBuilder();
        for (char[] row : chars) {
            for (char ch : row) {
                if (ch != 0) {
                    ans.append(ch);
                }
            }
        }
        return ans.toString();
    }


    public static String convert2(String s, int numRows) {
        if (numRows == 1 || numRows >= s.length())
            return s;
        int t = numRows * 2 - 2;
        StringBuilder ans = new StringBuilder();
        int t_count = s.length() / t;
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= t_count; j++) {
                ans.append(s.charAt(i + j * t));
            }
        }


        return ans.toString();
    }
}
