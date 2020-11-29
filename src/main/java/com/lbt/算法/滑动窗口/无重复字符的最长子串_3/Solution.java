package com.lbt.算法.滑动窗口.无重复字符的最长子串_3;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/29 13:17
 * 第3题：给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * 示例 1:
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。

 * 示例 3:
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *
 * 请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Solution {

    public static int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int left= 0;
        int right = 0;
        int result = 0;
        Set<Character> set = new HashSet<>();
        while(left<len && right <len){
            //如果set中没有包含字符
            if (!set.contains(s.charAt(right))){
                set.add(s.charAt(right));
                right++;
                result = Math.max(result,right-left);
            }else {
                set.remove(s.charAt(left));
                left++;
            }
        }
        return result;
    }
}
