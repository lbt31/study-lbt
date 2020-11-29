package com.lbt.算法.数组.买卖股票的最佳时机_123;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/29 14:40
123. 买卖股票的最佳时机 III
给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。

注意: **你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [3,3,5,0,0,3,1,4]
输出: 6
解释: 在第 4 天（股票价格 = 0）的时候买入，在第 6 天（股票价格 = 3）的时候卖出，这笔交易所能获得利润 = 3-0 = 3 。
     随后，在第 7 天（股票价格 = 1）的时候买入，在第 8 天 （股票价格 = 4）的时候卖出，这笔交易所能获得利润 = 4-1 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。  
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。  
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0
解释: 在这个情况下, 没有交易完成, 所以最大利润为 0。


 *
 */
public class Solution {

    //dp 标准的三维DP动态规划，三个维度，第一维表示天，第二维表示交易了几次，第三维表示是否持有股票。
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int k = 2;
        int[][][] dp = new int[len][k+1][2];

        for(int i = 0; i < len; i ++){
            for(int j = k; j > 0; j --){
                if (i == 0){
                    //第i天，还有j次，手里没有股票，当i=0，手里没股票，最大利润为0
                    dp[i][j][0] = 0;
                    //当i=0，手里有股票，因为还没有盈利，最大利润为 负prices[i]
                    dp[i][j][1] = -prices[i];
                    continue;
                }
                //今天手里没股票，比较MAX（前一天可能没股票，前一天有股票但是今天卖出去了，卖出去就有利润，所以+ prices[i]）
                dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
                //今天手里有股票，比较MAX（前一天可能有股票，前一天没股票但是今天买了，买了就有成本，所以- prices[i]）
                dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
            }
        }
        return dp[len-1][k][0];
    }

    public int maxProfit01(int[] prices) {
        /**
         对于任意一天考虑四个变量:
         fstBuy: 在该天第一次买入股票可获得的最大收益
         fstSell: 在该天第一次卖出股票可获得的最大收益
         secBuy: 在该天第二次买入股票可获得的最大收益
         secSell: 在该天第二次卖出股票可获得的最大收益
         分别对四个变量进行相应的更新, 最后secSell就是最大
         收益值(secSell >= fstSell)
         **/
        int fstBuy = Integer.MIN_VALUE, fstSell = 0;
        int secBuy = Integer.MIN_VALUE, secSell = 0;
        for(int p : prices) {
            fstBuy = Math.max(fstBuy, -p);
            fstSell = Math.max(fstSell, fstBuy + p);
            secBuy = Math.max(secBuy, fstSell - p);
            secSell = Math.max(secSell, secBuy + p);
        }
        return secSell;
    }
}
