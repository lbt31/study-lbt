package com.lbt.算法.数组.买卖股票的最佳时机_122;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/29 14:40
 * 122. 买卖股票的最佳时机 II
给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

示例 1:

输入: [7,1,5,3,6,4]
输出: 7
解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
示例 2:

输入: [1,2,3,4,5]
输出: 4
解释: 在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
     注意你不能在第 1 天和第 2 天接连购买股票，之后再将它们卖出。
     因为这样属于同时参与了多笔交易，你必须在再次购买前出售掉之前的股票。
示例 3:

输入: [7,6,4,3,1]
输出: 0

 *
 */
public class Solution {

    //DP
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int dp0 = 0 , dp1 = -prices[0]; //dp0代表前一天不持股票的利润，dp1代表前一天持股票的利润，这里用第0天初始化
        for(int i = 1;i<n;i++){
            int newDp0 = Math.max(dp0,dp1+prices[i]);
            int newDp1 = Math.max(dp1,dp0-prices[i]);
            dp0 = newDp0;
            dp1 = newDp1;
        }
        return dp0;
    }
    //贪心算法：扫描一遍 只要后一天比前一天大 就把这两天的差值加一下
    public int maxProfit01(int[] prices) {
        int ans=0;
        for(int i=1;i<=prices.length-1;i++)
        {
            if(prices[i]>prices[i-1])
            {
                ans+=prices[i]-prices[i-1];
            }
        }
        return ans;
    }
    
}
