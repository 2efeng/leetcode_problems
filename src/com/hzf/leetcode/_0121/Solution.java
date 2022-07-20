package com.hzf.leetcode._0121;

/**
 * 121. 买卖股票的最佳时机
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * <p>
 * 提示：
 * 1 <= prices.length <= 105
 * 0 <= prices[i] <= 104
 *
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/">...</a>
 */
public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxProfit(new int[]{7, 1, 5, 3, 6, 4}));

    }


    public int maxProfit(int[] prices) {
        int minPrice = prices[0];
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else if (prices[i] - minPrice > maxProfit) {
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }


    //利用第53. 最大子数组和
    public int maxProfit_053(int[] prices) {
        if (prices.length < 2) return 0;
        int maxProfit = 0;
        int temp;
        int lastPrice = prices[0];
        prices[0] = prices[0] * -1;
        for (int i = 1; i < prices.length; i++) {
            temp = prices[i];
            prices[i] = prices[i] - lastPrice;
            lastPrice = temp;
            if (prices[i - 1] > 0) {
                prices[i] = prices[i - 1] + prices[i];
            }
            maxProfit = Math.max(maxProfit, prices[i]);
        }
        return maxProfit;
    }

    //数据多会超时
    public int maxProfit_timeout(int[] prices) {
        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int currProfit = prices[j] - prices[i];
                maxProfit = Math.max(maxProfit, currProfit);
            }
        }
        return maxProfit;
    }
}
