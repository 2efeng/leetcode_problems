package com.hzf.leetcode._0118;

import java.util.ArrayList;
import java.util.List;

/**
 * 118. 杨辉三角
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * <p>
 * 提示:
 * 1 <= numRows <= 30
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generate(5));
    }


    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> last = null;
        for (int i = 1; i <= numRows; i++) {
            List<Integer> row = new ArrayList<>();
            if (last == null) row.add(1);
            else {
                row.add(0, 1);
                for (int j = 1; j < i - 1; j++) {
                    row.add(j, last.get(j - 1) + last.get(j));
                }
                row.add(i - 1, 1);
            }
            res.add(row);
            last = row;
        }
        return res;
    }


}
