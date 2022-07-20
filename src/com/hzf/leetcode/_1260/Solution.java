package com.hzf.leetcode._1260;

import java.util.ArrayList;
import java.util.List;

/**
 * 1260. 二维网格迁移
 * 给你一个 m 行 n 列的二维网格 grid 和一个整数 k。你需要将 grid 迁移 k 次。
 * 每次「迁移」操作将会引发下述活动：
 * 位于 grid[i][j] 的元素将会移动到 grid[i][j + 1]。
 * 位于 grid[i][n - 1] 的元素将会移动到 grid[i + 1][0]。
 * 位于 grid[m - 1][n - 1] 的元素将会移动到 grid[0][0]。
 * 请你返回 k 次迁移操作后最终得到的 二维网格。
 *
 * <a href="https://leetcode.cn/problems/shift-2d-grid/">...</a>
 * <a href="https://leetcode.cn/problems/shift-2d-grid/solution/er-wei-wang-ge-qian-yi-by-leetcode-solut-ploz/">...</a>
 */
public class Solution {


    public static void main(String[] args) {

        Solution solution = new Solution();
        int[][] grid = new int[][]{
                {3, 8, 1, 9},
                {19, 7, 2, 5},
                {4, 6, 11, 10},
                {12, 0, 21, 13},
        };
        int k = 16;

//        int[][] grid = new int[][]{
//                {1, 2, 3},
//                {4, 5, 6},
//                {7, 8, 9},
//        };
//        int k = 1;

//        int[][] grid = new int[][]{{1}};
//        int k = 100;

//        int[][] grid = new int[][]{{1}, {2}, {3}, {4}, {5}};
//        int k = 23;

        System.out.println(solution.shiftGrid(grid, k));
    }


    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        k = k % (m * n);
        int i = 0;
        int j = (n - k % n) % n;
        if (k > 0) i = m - 1 - (k - 1) / n;
        List<List<Integer>> res = new ArrayList<>();
        for (int l = 0; l < m; l++) {
            List<Integer> row = new ArrayList<>();
            for (int o = 0; o < n; o++) {
                row.add(grid[i][j]);
                if (j < n - 1) j++;
                else {
                    j = 0;
                    i++;
                    if (i >= m) i = 0;
                }
            }
            res.add(row);
        }
        return res;
    }

    /*
     *  int index1 = (i * n + j + k) % (m * n);
     *  ret.get(index1 / n).set(index1 % n, grid[i][j]);
     */

}
