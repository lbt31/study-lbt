package com.lbt.算法.数组.岛屿问题变种;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 14:55
 */
public class Main {
    /**
     * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands which the sum of 1‘s on the island equal S (S>0).
     * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
     * You may assume all four edges of the grid are all surrounded by water.
     * Example 1:
     * Input: grid = [
     * ["1","1","1","1","0"],
     *   ["1","1","0","1","0"],
     *   ["1","1","0","0","0"],
     *   ["0","0","0","0","0"]
     * ], S = 9
     * Output: 1
     * public int sumIslands(char[][] grid, int S){
     *     // implementation
     * }
     * //----------
     * // unit test
     * //----------
     * Tip: using Junit4.
     * public void sumIslandsTest(){
     *     char[][] grid = [
     *     ["1","1","1","1","0"],
     *     ["1","1","0","1","0"],
     *     ["1","1","0","0","0"],
     *     ["0","0","0","0","0"]
     *     ];
     *     int S = 8;
     *     // test implementation
     * }
     */
    public static void main(String[] args) {
        sumIslandsTest();
    }
    public static void sumIslandsTest(){
        char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '0'},
            {'0', '0', '0', '0', '0'}
        };
        int S = 8;
        // test implementation
        System.out.printf("岛屿面积为%s的岛屿有%s个",S,numIslands(grid,S));
    }

    private static Integer num=0;

    public static int numIslands(char[][] grid,int S) {
        int landNum = 0;
        int result = 0;
        List<Integer> f = new ArrayList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j = 0; j < grid[0].length; j++){
                if(grid[i][j] == '1'){
                    int infect = infect(grid, i, j);
                    f.add(infect);
                    landNum++;
                    num = 0;
                }
            }
        }
        //遍历数组
        for (int a : f){
            if (a == S){
                result+=1;
            }
        }

        return result;
    }

    public static int infect(char[][] grid, int i, int j){
        if(i < 0 || i >= grid.length ||
                j < 0 || j >= grid[0].length || grid[i][j] != '1'){
            return 0;
        }
        grid[i][j] = '2';
        num++;
        infect(grid, i + 1, j);
        infect(grid, i - 1, j);
        infect(grid, i, j + 1);
        infect(grid, i, j - 1);
        return num;
    }

}
