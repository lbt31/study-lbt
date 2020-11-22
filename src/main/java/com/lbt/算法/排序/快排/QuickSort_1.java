package com.lbt.算法.排序.快排;

import java.util.Arrays;
import java.util.Stack;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 0:37
 * 快速排序，非递归
 */
public class QuickSort_1 {


    public static void main(String[] args) {
        int[] arr = new int[]{5,2,1,4,6,7};
        quickSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void quickSort(int[] arr) {
        int left = 0;
        int right = arr.length-1;
        quickSort(arr,left,right);
    }
    public static void quickSort(int []arr, int left, int right) {
        int pivot;
        if (left >= right)
            return;
        //栈，先进后出
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(left);
        stack.push(right);
        while (!stack.empty()) {
            // 先弹出right,再弹出left
            right = stack.pop();
            left = stack.pop();
            pivot = QuickSort.partition(arr, left, right);
            // 先压left,再压right
            if (left < pivot - 1) {
                stack.push(left);
                stack.push(pivot - 1);
            }
            if (pivot + 1 < right) {
                stack.push(pivot + 1);
                stack.push(right);
            }
        }
    }
}
