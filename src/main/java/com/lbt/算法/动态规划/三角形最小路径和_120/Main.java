package com.lbt.算法.动态规划.三角形最小路径和_120;

import java.util.Arrays;
import java.util.List;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/14 15:21
 * 给定一个三角形，找出自顶向下的最小路径和。
 *每一步只能移动到下一行中相邻的结点上。
 *
 * 例如，给定三角形：
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。
 *综上我们就分析完了，我们总共进行了4步：
 *
 *
 *
 * 定义状态
 * 总结状态转移方程
 * 分析状态转移方程不能满足的特殊情况。
 * 得到最终解：result = min(dp[l-1,0]，dp[l-1,1]，dp[l-1,2]....)
 */
public class Main {

    public static void main(String[] args) {
        Integer[] a = new Integer[]{2};
        Integer[] b = new Integer[]{3,4};
        Integer[] c = new Integer[]{6,5,7};
        Integer[] d = new Integer[]{4,1,8,3};
        List<Integer> a1 = Arrays.asList(a);
        List<Integer> b1 = Arrays.asList(b);
        List<Integer> c1 = Arrays.asList(c);
        List<Integer> d1 = Arrays.asList(d);
        List<List<Integer>> triangle = Arrays.asList(a1,b1,c1,d1);


        System.out.printf("给定一个三角形，找出自顶向下的最小路径和为%s",minimumTotal(triangle));
    }

    public static int minimumTotal(List<List<Integer>> triangle) {
        if (triangle.size()<1){
            return 0;
        }
        if (triangle.size() == 1){
            return triangle.get(0).get(0);
        }
        int[][] dp = new int[triangle.size()+1][triangle.size()+1];
        //因为三角形从上到下会有边界问题，int[1][0]的上元素存在上左元素不存在，把三角形倒过来
        for (int i =triangle.size()-1;i>=0;i--){
            List<Integer> cur = triangle.get(i);
            for (int j=0;j<cur.size();j++){
                dp[i][j] = Math.min(dp[i+1][j+1],dp[i+1][j])+cur.get(j);
            }
        }
        return dp[0][0];
    }




    /**
     * //未优化内存版本
     * func minimumTotal(triangle [][]int) int {
     *     if len(triangle) < 1 {
     *         return 0
     *     }
     *     if len(triangle) == 1 {
     *         return triangle[0][0]
     *     }
     *     dp := make([][]int, len(triangle))
     *     for i, arr := range triangle {
     *         dp[i] = make([]int, len(arr))
     *     }
     *
     *     result := 2 << 31 + 1
     *     dp[0][0] = triangle[0][0]
     *     dp[1][1] = triangle[1][1] + triangle[0][0]
     *     dp[1][0] = triangle[1][0] + triangle[0][0]
     *
     *     for i := 2; i < len(triangle); i++ {
     *         for j := 0; j < len(triangle[i]); j++ {
     *             if j == 0 {
     *                 dp[i][j] = dp[i-1][j] + triangle[i][j]
     *             } else if j == (len(triangle[i]) - 1) {
     *                 dp[i][j] = dp[i-1][j-1] + triangle[i][j]
     *             } else {
     *                 dp[i][j] = min(dp[i-1][j-1], dp[i-1][j]) + triangle[i][j]
     *             }
     *         }
     *     }
     *     for _,k := range dp[len(dp)-1] {
     *         result = min(result, k)
     *     }
     *     return result
     * }
     *
     * func min(a, b int) int {
     *     if a > b {
     *         return b
     *     }
     *     return a
     * }
     */





}
