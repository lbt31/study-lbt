package com.lbt.算法.字符串.反转字符串_344;

import java.util.Arrays;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/14 18:45
 * 编写一个函数，其作用是将输入的字符串反转过来。输入字符串以字符数组 char[] 的形式给出。
 * 不要给另外的数组分配额外的空间，你必须原地修改输入数组、使用 O(1) 的额外空间解决这一问题。
 *
 * 示例 1：
 * 输入：["h","e","l","l","o"]
 * 输出：["o","l","l","e","h"]
 *
 * 示例 2：
 * 输入：["H","a","n","n","a","h"]
 * 输出：["h","a","n","n","a","H"]
 * 解题思路：定义两个指针，当left>right是交换
 */
public class Main {

    public static void main(String[] args) {
        String s = "hello";
        reverseString(s.toCharArray());

    }
    public static void reverseString(char[] s) {
        int left = 0;
        int right = s.length-1;
        while (left<right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
        System.out.println(Arrays.toString(s));
    }
}
