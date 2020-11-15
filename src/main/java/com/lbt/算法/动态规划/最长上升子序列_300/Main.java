package com.lbt.算法.动态规划.最长上升子序列_300;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/14 13:51
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * 示例:
 *
 * 输入: [10,9,2,5,3,7,101,18]
 *
 * 输出: 4
 *
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 *
 * 说明:
 *
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 *
 *
 * 解题思路： 用一个数组将一一对应下标记录他值前有几个小于他的数
 */
public class Main {
    public static void main(String[] args) {
        int[] nums = new int[]{10,9,2,5,3,7,101,18};
        System.out.printf("最长上升子序列为%s",maxSubArray(nums));
    }
    public static int maxSubArray(int[] nums){
        if (nums.length<1){
            return 0;
        }
        int[] dp = new int[nums.length];
        int result = 1;
        for (int i = 0; i<nums.length;i++){
            dp[i] = 1;
            for (int j=0;j<i;j++){
                if (nums[j]<nums[i]){
                    dp[i]=Math.max(dp[j]+1,dp[i]);
                }
            }
            result = Math.max(result,dp[i]);
        }
        return result;


    }
    /**
     * func lengthOfLIS(nums []int) int {
     *     if len(nums) < 1 {
     *         return 0
     *     }
     *     dp := make([]int, len(nums))
     *     result := 1
     *     for i := 0; i < len(nums); i++ {
     *         dp[i] = 1
     *         for j := 0; j < i; j++ {
     *             //这行代码就是上文中那个 等等等等
     *             if nums[j] < nums[i] {
     *                 dp[i] = max(dp[j]+1, dp[i])
     *             }
     *         }
     *         result = max(result, dp[i])
     *     }
     *     return result
     * }
     *
     * func max(a, b int) int {
     *     if a > b {
     *         return a
     *     }
     *     return b
     * }
     */

}
