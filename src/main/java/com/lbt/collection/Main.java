package com.lbt.collection;

import java.util.*;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/23 22:32
 */
public class Main {

    /**
     * 编写一个函数,寻找一个正整数x,他的平方最接近正整数y。
     */
    public static int  find(int y){


        //定义返回值
        int x ;
        //是否二分标志位
        boolean sign = true;
        int mid = y/2;
        while(true){
            int p = mid*mid;
            if (p==y){
                x = mid;
                break;
            }
            if ( sign && p > y){
                mid = mid/2;
                continue;
            }
            if (p<y){
                sign = false;
                mid++;
            }
            if (p > y){
                x = mid-1;
                break;
            }
        }
        return x;
    }

    public static int find01(int y){
        //定义左指针
        int left = 0;
        //定义右指针
        int right = y;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (mid * mid == y) {
                return  mid;
            }
            else if (mid * mid < y) {
                left =  (mid + 1);
            }
            else {
                right =  (mid - 1);
            }
        }
        return right;
    }


    public static void main(String[] args) {
       Integer ra = Integer.MAX_VALUE;
       Random random = new Random();
       List<Integer> list = new ArrayList<>();
       //随机生成1000个
       for (int i=0;i<1000;i++){
           list.add(random.nextInt(ra));
       }
       list.forEach( t ->{
           double sqrt = Math.sqrt(Double.valueOf(t));
           int result = Integer.valueOf(String.valueOf(sqrt));
           if (result != find01(t)){
               System.out.printf("测试失败：%s的平方最接近%s",result,t);
           }
       });
        System.out.println("测试成功，全部通过！");
    }

}
