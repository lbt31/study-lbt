package com.lbt.sort;

import java.util.Arrays;

/**
 * @Author LiBiTong
 * @Description 选择排序
 * 选择排序将待排序序列分成未排序区和已排序区；
 * 第一趟排序的时候整个待排序序列是未排序区；
 * 每一趟排序其实就是从未排序区选择一个最值，放到已排序区；
 * 跑 len-1 趟就好
 * @Date 2020/9/10 22:41
 */
public class SwitchSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,6,2,3,4,1,9};

        switchSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void switchSort(int[] arr) {
        for (int i = 0;i<arr.length-1;i++){
            int flag = i;
            for (int j =i+1;j<arr.length;j++){
                if (arr[j]<arr[flag]){
                    flag = j;
                }
            }
            if (flag != i){
                int temp = arr[i];
                arr[i] = arr[flag];
                arr[flag] = temp;
            }
        }



    }

}
