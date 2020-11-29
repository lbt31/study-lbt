package com.lbt.算法.二分法.吃香蕉_875;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/24 23:53
 * 不知道为什么叫做爱吃香蕉的阿珂，难道不应该是爱吃香蕉的猴子么...或者爱吃队友的露娜么？
 * 第875题：阿珂喜欢吃香蕉。这里总共有 N 堆香蕉，第 i 堆中有piles[i] 根香蕉。警卫已经离开了，将在 H 小时后回来。
 * 阿珂可以决定她吃香蕉的速度 K （单位：根/小时），每个小时，她将会选择一堆香蕉，从中吃掉 K 根。*
 * 珂珂喜欢慢慢吃，但仍然想在警卫回来前吃掉所有的香蕉。
 *
 * 返回她可以在 H 小时内吃掉所有香蕉的最小速度 K（K 为整数）。
示例 1：
输入: piles = [3,6,7,11], H = 8
输出: 4
示例 2：
输入: piles = [30,11,23,4,20], H = 5
输出: 30
示例 3：
输入: piles = [30,11,23,4,20], H = 6
输出: 23


一般题目不太可能给你一个如此现成的题型，让你上手就可以使用二分，所以我们需要思考，如何来构
造一个成功的二分查找。大部分的二分查找，基本都由以下三步组成：
    预处理过程（大部分场景就是对未排序的集合进行排序）
    二分查找过程（找到合适的循环条件，每一次将查找空间一分为二）
    后处理过程（在剩余的空间中，找到合适的目标值）

总结一下一般实现的几个条件：
    初始条件：left = 0, right = length-1
    终止：left > right
    向左查找：right = mid-1
    向右查找：left = mid+1

注意，绝大部分「在递增递减区间中搜索目标值」 的问题，都可以转化为二分查找问题。
并且，二分查找的题目，基本逃不出三种：找特定值，找大于特定值的元素（上界），找小于特定值的元素（下界）。

    而根据这三种，代码又最终会转化为以下这些问题：
    low、high 要初始化为 0、n-1 还是 0、n 又或者 1，n？
    循环的判定条件是 low < high 还是 low <= high？
    if 的判定条件应该怎么写？
    if 条件正确时，应该移动哪边的边界？
    更新 low 和 high 时，mid 如何处理？


 */
public class Solution {

    //这里我把最小速度定义成了1，可能大家会觉得奇怪，模板里不是0吗？
    //所以这里我其实是想说，算法千变万化，大家不要生搬硬套。
    //从字面理解，如果定义成0，意味着阿珂会选择一个香蕉都不吃，难道阿珂傻？
    public int minEatingSpeed(int[] piles, int H) {
        int maxVal = 1;
        for (int pile : piles) {
            maxVal = Math.max(maxVal, pile);
        }
        int left = 1;
        int right = maxVal;
        while (left < right) {
            int mid = (left+right)/2;
            if (canEat(piles,H,mid)){
                left = mid+1;
            }else right = mid;
        }
        return left;
    }

    private boolean canEat(int[] piles, int h, int mid) {
        int sum = 0;
        for (int pile : piles){
            //向上取整
            //+1，是为了解决当pile=mid时，相除=2
            sum += (pile+mid-1)/mid;
        }
        return sum>h;
    }
}
