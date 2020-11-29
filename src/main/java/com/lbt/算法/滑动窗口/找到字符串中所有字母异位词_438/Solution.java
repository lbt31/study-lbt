package com.lbt.算法.滑动窗口.找到字符串中所有字母异位词_438;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/29 14:04
 * 第438题：给定一个字符串 s 和一个非空字符串 p，找到 s 中所有是 p 的字母异位词的子串，返回这些子串的起始索引。
 * 字符串只包含小写英文字母，并且字符串 s 和 p 的长度都不超过 20100。
 *
 *
 *
 * 说明：
 *
 * 字母异位词指字母相同，但排列不同的字符串。
 *
 * 不考虑答案输出的顺序。

 * 示例 1:
 * 输入:
 * s: "cbaebabacd" p: "abc"
 * 输出:
 * [0, 6]

 * 解释:
 * 起始索引等于 0 的子串是 "cba", 它是 "abc" 的字母异位词。
 * 起始索引等于 6 的子串是 "bac", 它是 "abc" 的字母异位词。
 * 示例 2:
 * 输入:
 * s: "abab" p: "ab"
 * 输出:
 * [0, 1, 2]

 * 解释:
 *
 * 起始索引等于 0 的子串是 "ab", 它是 "ab" 的字母异位词。
 *
 * 起始索引等于 1 的子串是 "ba", 它是 "ab" 的字母异位词。
 *
 * 起始索引等于 2 的子串是 "ab", 它是 "ab" 的字母异位词。
 */
public class Solution {

    public List<Integer> findAnagrams(String s, String p) {

        //边界值处理
        if (s == null || p == null || s.length() < p.length()) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        int[] pArr = new int[26];
        int[] sArr = new int[26];
        //将字符比较转为数字比较
        for (int i = 0; i < p.length(); i++) {
            sArr[s.charAt(i) - 'a']++;
            pArr[p.charAt(i) - 'a']++;
        }
        int i = 0;
        int j = p.length();

        // 窗口大小固定为p的长度
        while (j < s.length()) {
            if (isSame(pArr, sArr))
                list.add(i);
            //sArr[s.charAt(i) - 'a']-- 左指针位置处字母减1
            sArr[s.charAt(i) - 'a']--;
            i++;
            //sArr[s.charAt(j) - 'a']++ 右指针位置处字母加1
            sArr[s.charAt(j) - 'a']++;
            j++;
        }

        if (isSame( pArr, sArr)){
            list.add(i);

        }
        return list;
    }

    public boolean isSame(int[] arr1, int[] arr2) {
        for (int i = 0; i < arr1.length; ++i)
            if (arr1[i] != arr2[i])
                return false;
        return true;
    }
}
