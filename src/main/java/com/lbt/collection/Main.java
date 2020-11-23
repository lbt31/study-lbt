package com.lbt.collection;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/23 22:32
 */
public class Main {

    /**
     * 编写一个函数,寻找一个正整数x,他的平方最接近正整数y。
     * 输入y，找到一个数x，x的平方接近y
     */
    public static int  find(int y){
        int low = 1;
        int high = y;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // int product = mid * mid;   越界
            int t = y / mid;
            if (t == mid) {
                if (y % mid == 0) {
                    return t;
                }
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

    //给定一个正整数 num，编写一个函数，如果 num 是一个完全平方数，则返回 True，否则返回 False。
    public boolean isPerfectSquare(int num) {
        int low = 1;
        int high = num;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            // int product = mid * mid;   越界
            int t = num / mid;
            if (t == mid) {
                if (num%mid == 0) return true;
                low = mid + 1;
            } else if (t < mid) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return false;
    }

}
