package com.hzf.leetcode._0085_x;

/**
 * 85. 最大矩形
 * 给定一个仅包含 0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
 *
 * 提示：
 * rows == matrix.length
 * cols == matrix[0].length
 * 1 <= row, cols <= 200
 * matrix[i][j] 为 '0' 或 '1'
 *
 * 1  0  1  0  0
 *       ________
 * 1  0 |1  1  1 |
 * 1  1 |1  1  1 |
 *      ---------
 * 1  0  0  1  0
 *
 * 链接：<a href="https://leetcode.cn/problems/maximal-rectangle">...</a>
 */
public class Solution {

    public int maximalRectangle(char[][] matrix) {

        if (matrix.length == 0) return 0;
        int max = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (matrix[i][j] == 0)  continue;
//                int area = 1;
//
//
//            }
//        }
        return 0;
    }


}
