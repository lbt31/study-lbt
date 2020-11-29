package com.lbt.算法.二分法.平方根_69;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/25 0:40
 * 第69题：实现 int sqrt(int x) 函数
 * 计算并返回 x 的平方根，其中 x 是非负整数。由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
 */
public class Solution {

    public int mySqrt(int x) {
        int left = 0;
        int right = x;
        while (left <= right) {
            long mid = (left + right) / 2;

            if (mid * mid == x) {
                return (int) mid;
            }
            else if (mid * mid < x) {
                left = (int) (mid + 1);
            }
            else{
                right = (int) (mid - 1);
            }

        }
        return right;
    }
    public int mySqrt01(int x) {
       if (x == 0) return 0;
       long left = 1;
       long right = x / 2;
       while (left < right) {
            //注意这一行代码
            long mid = (right + left) / 2 + 1;
            if (mid > x / mid) {
                right = mid - 1;
            } else {
                left = mid;
            }
        }
       return (int) left;
    }
}
