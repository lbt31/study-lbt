package com.lbt.算法.动态规划.最大子序和_53;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/14 13:30
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * 示例:
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 *
 * 输出: 6
 *
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * 解决思路：遍历数组找到不为负数和0的值，然后相加在判断是否小于0，小于舍去.
 */
public class Main {

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.printf("最大子序和为%s",maxSubArray(nums));
        System.out.printf("最大子序和为%s",maxSubArray2(nums));
    }
    public static int maxSubArray(int[] nums){
        if (nums.length < 1) {
            return 0;
        }
        //***记录最大值**
        int rep = nums[0];
         int sum=0;
        for (int num : nums){
            if (sum>0){
                sum+=num;
            }
            else{
                sum = num;
            }
            rep = Math.max(rep,sum);
        }
        return rep;




    }
    public static int maxSubArray2(int[] nums){
        if (nums.length < 1) {
            return 0;
        }
        int[] dp = new int[nums.length];
        //设置初始值
        dp[0]= nums[0];
        //结果值
        int result = 0;
        for (int i =1;i<nums.length;i++){
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            result = Math.max(dp[i],result);
        }
        return result;

    }

    /**
     * func maxSubArray(nums []int) int {
     *     if len(nums) < 1 {
     *         return 0
     *     }
     *     dp := make([]int, len(nums))
     *     //设置初始化值
     *     dp[0] = nums[0]
     *     for i := 1; i < len(nums); i++ {
     *         //处理 dp[i-1] < 0 的情况
     *         if dp[i-1] < 0 {
     *             dp[i] = nums[i]
     *         } else {
     *             dp[i] = dp[i-1] + nums[i]
     *         }
     *     }
     *     result := -1 << 31
     *     for _, k := range dp {
     *         result = max(result, k)
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
