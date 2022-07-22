package com.hzf.leetcode._0757;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 757. 设置交集大小至少为2
 * 一个整数区间 [a, b]  ( a < b ) 代表着从 a 到 b 的所有连续整数，包括 a 和 b。
 * 给你一组整数区间intervals，请找到一个最小的集合 S，使得 S 里的元素与区间intervals中的每一个整数区间都至少有2个元素相交。
 * 输出这个最小集合S的大小。
 * <p>
 * 注意:
 * <p>
 * intervals 的长度范围为[1, 3000]。
 * intervals[i] 长度为 2，分别代表左、右边界。
 * intervals[i][j] 的值是 [0, 10^8]范围内的整数。
 * <p>
 * 链接：<a href="https://leetcode.cn/problems/set-intersection-size-at-least-two">...</a>
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = new int[][]{{1, 3}, {1, 4}, {2, 5}, {3, 5}};
        System.out.println(solution.intersectionSizeTwo(intervals));
    }

    public int intersectionSizeTwo(int[][] intervals) {
        int len = intervals.length;
        Map<Integer, Integer> record = new HashMap<>();
        for (int i = 0; i < len; i++) {
            record.put(i, 0);
        }
        List<Integer> nums = new ArrayList<>();
        boolean isFinished;
        boolean isInterval;
        int max = intervals[0][0];
        int num = 1;
        while (num <= max) {
            isInterval = true;
            for (int i = 0; i < intervals.length; i++) {
                max = Math.max(max, intervals[i][1]);
                if (record.get(i) >= 2) continue;
                if (intervals[i][0] > num || intervals[i][1] < num) {
                    isInterval = false;
                    break;
                }
            }
            if (isInterval) {
                nums.add(num);
                isFinished = true;
                for (int i = 0; i < len; i++) {
                    int count = record.get(i) + 1;
                    record.put(i, count);
                    if (isFinished && count < 2) isFinished = false;
                }
                if (isFinished) return nums.size();
                num = 1;
            } else {
                num++;
                while (nums.contains(num)) {
                    num++;
                }
            }
        }
        return (2 - nums.size()) * len + nums.size();
    }
}
