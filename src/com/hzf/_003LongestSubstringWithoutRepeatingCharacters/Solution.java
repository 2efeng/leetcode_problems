package com.hzf._003LongestSubstringWithoutRepeatingCharacters;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 3. 无重复字符的最长子串（中等）
 * 给定一个字符串s，请你找出其中不含有重复字符的最长子串的长度。
 * <p>
 * <p>
 * <p>
 * 提示：
 * 0 <= s.length <= 5 * 104
 * s 由英文字母、数字、符号和空格组成
 * <p>
 * 链接：https://leetcode.cn/problems/longest-substring-without-repeating-characters/
 */
public class Solution {


    public static void main(String[] args) {
        Solution solution = new Solution();
        // 3。  因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        System.out.println(solution.lengthOfLongestSubstring("abcabcbb"));
        // 1。  因为无重复字符的最长子串是 "b"，所以其长度为 1。
        System.out.println(solution.lengthOfLongestSubstring("bbbbb"));
        // 3。  因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        // 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
        System.out.println(solution.lengthOfLongestSubstring("pwwkew"));
        // 3 vdf
        System.out.println(solution.lengthOfLongestSubstring("dvdf"));
        // 2
        System.out.println(solution.lengthOfLongestSubstring("aab"));
    }


    public int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) return 0;
        if (s.length() == 1) return 1;
        int maxLen = 1;
        int left = 0, right = 1;
        Set<Character> occ = new HashSet<>();
        occ.add(s.charAt(left));
        while (right < s.length()) {
            if (right == left) {
                occ.add(s.charAt(right));
                right++;
                continue;
            }
            if (occ.contains(s.charAt(right))) {
                occ.remove(s.charAt(left));
                left++;

            } else {
                occ.add(s.charAt(right));
                maxLen = Math.max(occ.size(), maxLen);
                right++;
            }
        }
        return maxLen;
    }

    public int lengthOfLongestSubstring2(String s) {
        // 哈希集合，记录每个字符是否出现过
        Set<Character> occ = new HashSet<>();
        int n = s.length();
        // 右指针，初始值为 -1，相当于我们在字符串的左边界的左侧，还没有开始移动
        int rk = -1, ans = 0;
        for (int i = 0; i < n; ++i) {
            if (i != 0) {
                // 左指针向右移动一格，移除一个字符
                occ.remove(s.charAt(i - 1));
            }
            while (rk + 1 < n && !occ.contains(s.charAt(rk + 1))) {
                // 不断地移动右指针
                occ.add(s.charAt(rk + 1));
                ++rk;
            }
            // 第 i 到 rk 个字符是一个极长的无重复字符子串
            ans = Math.max(ans, rk - i + 1);
        }
        return ans;
    }


}
