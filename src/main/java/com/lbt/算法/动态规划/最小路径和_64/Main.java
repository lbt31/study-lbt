package com.lbt.算法.动态规划.最小路径和_64;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/14 17:47
 * 给定一个包含非负整数的 m * n 网格，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
 * 说明：每次只能向下或者向右移动一步。
 * 示例:
 * 输入:
 * [
 *   [1,3,1],
 *   [1,5,1],
 *   [4,2,1]
 * ]
 * 输出: 7
 * 解释: 因为路径 1→3→1→1→1 的总和最小。
 */
public class Main {
    //dp[i][j] = min(dp[i-1][j],dp[i][j-1]) + grid[i][j]
    //综上我们就分析完了，我们总共进行了4步：
        //定义状态
        //总结状态转移方程
        //分析状态转移方程不能满足的特殊情况。
        //得到最终解
    public static void main(String[] args) {

    }

    public static int minPathSum(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0] == null || grid[0].length < 1) {
            return 0;
        }
        int row = grid.length;
        int col = grid[row-1].length;
        int[][] dp = new int[row][col];
        //两种特殊情况，一个从上-右，一个从上到下
        dp[0][0] = grid[0][0];
        //一个从上-右
        for (int i= 1;i<col;i++){
            dp[0][i] += dp[0][i-1]+grid[0][i];
        }
        //上到下
        for (int i= 1;i<row;i++){
            dp[i][0] += dp[i-1][0]+grid[i][0];
        }
        for (int i = 1;i<row;i++){
            for (int j=1;j<col;j++){
                dp[i][j] = Math.min(dp[i-1][j],dp[i][j-1])+grid[i][j];
            }
        }
        return dp[row - 1][col - 1]; 
    }
}
