package com.hzf.leetcode._119;

import java.util.ArrayList;
import java.util.List;

/**
 * 119. 杨辉三角 II
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 *
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">...</a>
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getRow3(5));

    }

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = null;
        List<Integer> last = null;
        for (int i = 0; i <= rowIndex; i++) {
            res = new ArrayList<>();
            if (i == 0) res.add(1);
            else {
                res.add(0, 1);
                for (int j = 1; j < i; j++) {
                    res.add(j, last.get(j - 1) + last.get(j));
                }
                res.add(i, 1);
            }
            last = res.stream().toList();
        }
        return res;
    }


    public List<Integer> getRow2(int rowIndex) {
        List<Integer> row = new ArrayList<>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i++) {
            row.add((int) ((long) row.get(i - 1) * (rowIndex - i + 1) / i));
        }
        return row;
    }

    public List<Integer> getRow3(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; ++i) {
            row.add(0);
            for (int j = i; j > 0; --j) {
                row.set(j, row.get(j) + row.get(j - 1));
            }
        }
        return row;
    }


}

