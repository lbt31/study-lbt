package com.lbt.算法.滑动窗口.滑动窗口最大值_239;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/29 12:31
 * 第239题：给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。
 * 你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。返回滑动窗口中的最大值。
 *
 * 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。
 * 滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值所构成的数组。
 *
 * 示例:
 * 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
 *
 * 输出: [3,3,5,5,6,7]
 *
 * 解释:
 *   滑动窗口的位置                最大值
 *
 * ---------------               -----
 *
 * [1  3  -1] -3  5  3  6  7       3
 *
 *  1 [3  -1  -3] 5  3  6  7       3
 *
 *  1  3 [-1  -3  5] 3  6  7       5
 *
 *  1  3  -1 [-3  5  3] 6  7       5
 *
 *  1  3  -1  -3 [5  3  6] 7       6
 *
 *  1  3  -1  -3  5 [3  6  7]      7
 */
public class Solution {

    public int[] maxSlidingWindow(int[] nums, int k) {
        int length = nums.length;
        if(length==0){
            return new int[0];
        }
        int[] win = new int[length-k+1];
        //**length-k+1很重要
        for (int i = 0;i<length-k+1;i++){
            //因为数组中的数可能为负数
            int max = Integer.MIN_VALUE;
            for (int j = i;j<i+k;j++){
                max = Math.max(max,nums[j]);
            }
            win[i] = max;
        }
        return win;
    }

}
