package com.lbt.算法.排序.快排;

import java.util.Arrays;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/21 20:33
 *  快排：O(Nlog2N)
 *   我们从数组中选择一个元素，我们把这个元素称之为中轴元素吧，然后把数组中所有小于中轴元素的元素放在其左边，
 *   所有大于或等于中轴元素的元素放在其右边，显然，此时中轴元素所处的位置的是有序的。也就是说，我们无需再移动中轴元素的位置。
 *
 *   从中轴元素那里开始把大的数组切割成两个小的数组(两个数组都不包含中轴元素)，接着我们通过递归的方式，让中轴元素左边的
 *   数组和右边的数组也重复同样的操作，直到数组的大小为1，此时每个元素都处于有序的位置。
 */
public class QuickSort {

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

    private static void quickSort(int[] arr,int left,int right) {
        if(left<right){
            int index = partition(arr,left,right);
            quickSort(arr,left,index-1);
            quickSort(arr,index+1,right);

        }

    }

    public static int partition(int []arr, int left, int right) {
        int privot = left;//快排支点。一般是最左边的元素
        while(left<right) {
            //从右往左走，找到第一个小于基准值的值
            while((arr[privot]<arr[right])&left<right) {
                right--;
            }
            //进行交换
            int temp = arr[right];
            arr[right] = arr[privot];
            arr[privot] = temp;
            //替换基准值
            privot = right;

            //从左往右走，找到第一个大于基准值的值
            while((arr[left]<arr[privot])&left<right) {
                left++;
            }
            //进行交换
            temp = arr[left];
            arr[left] = arr[privot];
            arr[privot] = temp;
            //替换基准值
            privot = left;
        }
        return privot;
    }




    private static int partition_1(int[] arr, int left, int right) {
        //选取中轴元素
       int pivot = arr[left];
       int i = left + 1;
       int j = right;
       while (true) {
           // 向右找到第一个大于等于 pivot 的元素位置
           while (i <= j && arr[i] <= pivot) {
               i++;
           }
           // 向左找到第一个小于于等于 pivot 的元素位置
           while(i <= j && arr[j] >= pivot ) {
               j--;
           }
           if(i >= j) break;
           //交换两个元素的位置，使得左边的元素不大于pivot,右边的不小于pivot
           int temp = arr[i];
           arr[i] = arr[j];
           arr[j] = temp;
        }
       arr[left] = arr[j];
       // 使中轴元素处于有序的位置
       arr[j] = pivot;
       return j;


    }
    private static void swap(int[] arr,int i,int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
