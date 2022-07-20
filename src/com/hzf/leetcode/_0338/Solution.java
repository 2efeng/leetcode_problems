package com.hzf.leetcode._0338;

/**
 * 338. 比特位计数
 * 给你一个整数 n ，对于 0 <= i <= n 中的每个 i ，计算其二进制表示中 1 的个数 ，返回一个长度为 n + 1 的数组 ans 作为答案。
 * <p>
 * 提示：
 * 0 <= n <= 10^5
 * <p>
 * 进阶：
 * 很容易就能实现时间复杂度为 O(n log n) 的解决方案，你可以在线性时间复杂度 O(n) 内用一趟扫描解决此问题吗？
 * 你能不使用任何内置函数解决此问题吗？（如，C++ 中的__builtin_popcount ）
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：<a href="https://leetcode.cn/problems/counting-bits">...</a>
 * 题解：<a href="https://leetcode.cn/problems/counting-bits/solution/bi-te-wei-ji-shu-by-leetcode-solution-0t1i/">...</a>
 */
public class Solution {


    //Integer.toBinaryString(i).toCharArray();


    public static void main(String[] args) {
//        Solution solution = new Solution();
//        System.out.println(Arrays.toString(solution.countBits(85723)));
    }


    public int[] countBits(int n) {
        int[] res = new int[n + 1];
        res[0] = 0;
        String lastBits = "0";
        StringBuilder tempBits;
        int count;
        boolean isIncc;
        for (int i = 1; i <= n; i++) {
            isIncc = true;
            count = 0;
            tempBits = new StringBuilder();
            for (int index = lastBits.length() - 1; index >= 0; index--) {
                char c = lastBits.charAt(index);
                if (isIncc) {
                    if (c == '0') {
                        c = '1';
                        isIncc = false;
                    } else {
                        c = '0';
                    }
                }
                if (c == '1') count++;
                tempBits.insert(0, c);
            }
            if (isIncc) {
                tempBits.insert(0, 1);
                count++;
            }
            lastBits = tempBits.toString();
            res[i] = count;
        }
        return res;
    }


    /**
     * &运算（位运算）
     * &运算中1&1=1,1&0=0,0&0=0
     */
    public int[] countBits2(int n) {
        int[] bits = new int[n + 1];
        int highBit = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) {
                highBit = i;
            }
            bits[i] = bits[i - highBit] + 1;
        }
        return bits;
    }


    public int[] countBits3(int n) {
        int[] bits = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            bits[i] = countOnes(i);
        }
        return bits;
    }

    public int countOnes(int x) {
        int ones = 0;
        while (x > 0) {
            x &= (x - 1);
            ones++;
        }
        return ones;
    }


    public int[] countBits4(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i >> 1] + (i & 1);
        }
        return bits;
    }

    public int[] countBits5(int n) {
        int[] bits = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            bits[i] = bits[i & (i - 1)] + 1;
        }
        return bits;
    }


}
