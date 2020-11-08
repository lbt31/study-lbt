package com.lbt.sort;

import java.util.Arrays;

/**
 * @Author LiBiTong
 * @Description  冒泡排序：
 * 以升序为例，就是比较相邻两个数，如果逆序就交换，类似于冒泡；
 * 一次冒泡确定一个数的位置，因为要确定 n-1 个数，因此需要 n-1次冒泡；
 * 冒泡排序时，其实相当于把整个待排序序列分为未排序区和已排序区
 * @Date 2020/9/10 21:52
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = new int[]{8,4,5,6,2,3,4,1,9};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
        /*Arrays.asList(arr).stream().forEach(a -> System.out.print(a ));
        Stream.of(arr).forEach(System.out::println);*/
    }

    public static void bubbleSort(int[] arr){
        for (int i = 0;i<arr.length-1;i++){
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }
    public static void bubbleSortPlus(int[] arr){

        for (int i = 0;i<arr.length-1;i++){
            int flag = 0;
            for (int j = 0;j<arr.length-1-i;j++){
                if (arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    flag++;
                }
            }
            //说明已经有序
            if (flag == 0){
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }
}
