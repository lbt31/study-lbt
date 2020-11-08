package com.lbt.sort;

import java.util.Arrays;

/**
 * @Author LiBiTong
 * @Description 插入排序
 * 插入排序也相当于把待排序序列分成已排序区和未排序区；
 * 每趟排序都将从未排序区选择一个元素插入到已排序合适的位置；
 * 假设第一个元素属于已排序区，那么还需要插入 len-1 趟；
 *
 * @Date 2020/9/10 22:18
 */
public class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,6,2,3,4,1,9};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertSort(int[] arr){
        for (int i = 1;i<arr.length;i++){
            //取后一个数跟前一个数比较
            int temp = arr[i];
            int j;
            for( j= i-1; j>=0;j--){
                if (arr[j] > temp){
                    arr[j+1] = arr[j];
                }
                else break;
            }
            arr[j+1] = temp;
        }
    }
}
