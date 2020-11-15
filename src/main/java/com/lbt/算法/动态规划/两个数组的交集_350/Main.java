package com.lbt.算法.动态规划.两个数组的交集_350;

/**我们先来看一道题目：
 示例 1:输入: nums1 = [1,2,2,1], nums2 = [2,2]
 输出: [2,2]
 示例 2:输入: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 输出: [4,9]
 说明：
 输出结果中每个元素出现的次数，应与元素在两个数组中出现的次数一致。
 我们可以不考虑输出结果的顺序。
 进阶:
 如果给定的数组已经排好序呢？将如何优化你的算法呢？*/

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/12 0:09
 */
public class Main {
   //首先拿到这道题，我们基本马上可以想到，此题可以看成是一道传统的映射题（map映射），为
    //什么可以这样看呢，因为我们需找出两个数组的交集元素，同时应与两个数组中出现的次数一
    //致。这样就导致了我们需要知道每个值出现的次数，所以映射关系就成了<元素,出现次数>。剩下
    //的就是顺利成章的解题。

   /* public int[] inter(int[] num1,int[] num2){
        HashMap<Integer ,Integer> m0 = new HashMap<Integer, Integer>();
        for (int v: num1) {
            m0.get(Integer.valueOf(v))+Integer.valueOf(1);
        }
        int k =0;
        for (int v:num2) {
            if (m0.get(v)>0){

            }
        }

    }*/


}
