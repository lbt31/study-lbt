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
        //定义返回值
        int x ;
        //是否二分标志位
        boolean a = true;
        int mid = y;
        while(true){
             if (a){
                 mid = mid/2;
             }
             int p = mid*mid;
            if (p==y){
                x = mid;
                break;
            }
             if ( a && p > y){
                 continue;
             }

             if (p<y){
                 a = false;
                mid++;
             }
            if (p > y){
                x = mid-1;
                break;
            }
        }
        return x;
    }

    public static void main(String[] args) {
        System.out.println(find(81));
    }

}
