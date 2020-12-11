package com.lbt.算法.字符串.KMP;

import java.util.ArrayList;
import java.util.List;

public class Solution {


    /**
     * kmp讲解：<a>https://www.zhihu.com/question/21923021</a>
     * 链接：https://www.zhihu.com/question/21923021/answer/37475572
     */


    public static void main(String[] args) {
        List<Integer> search = search("abbaabbaaba", "abbaaba");

        search.forEach(System.out::println);
    }

    // 在文本 text 中寻找模式串 pattern，返回所有匹配的位置开头
    static List<Integer> search(String text, String pattern) {
        List<Integer> positions = new ArrayList<>();
        int[] maxMatchLengths = calculateMaxMatchLengths(pattern);
        int count = 0;
        for (int i = 0; i < text.length(); i++) {
            while (count > 0 && pattern.charAt(count) != text.charAt(i)) {
                count = maxMatchLengths[count - 1];
            }
            if (pattern.charAt(count) == text.charAt(i)) {
                count++;
            }
            if (count == pattern.length()) {
                positions.add(i - pattern.length() + 1);
                count = maxMatchLengths[count - 1];
            }
        }
        return positions;
    }


    /**
     *
     * 列个表手算一下：（最大匹配数为子字符串 [0...i] 的最长匹配的长度）
     * 子字符串　 a b a b a b z a b a b a b a
     * 最大匹配数 0 0 1 2 3 4 0 1 2 3 4 5 6 ?
     * 一直算到 6 都很容易。在往下算之前，先回顾下我们所做的工作：对子字符串 abababzababab 来说，
     *
     * 真前缀有 a, ab, aba, abab, ababa, ababab, abababz, ...
     * 真后缀有 b, ab, bab, abab, babab, ababab, zababab, ...
     *
     * 所以
     * 子字符串 abababzababab 的真前缀和真后缀最大匹配了 6 个（ababab），那次大匹配了多少呢？容易看出次大匹配了 4 个（abab），
     * 更仔细地观察可以发现，次大匹配必定在最大匹配 ababab 中，所以次大匹配数就是 ababab 的最大匹配数！直接去查算出的表，可以得出该
     * 值为 4。第三大的匹配数同理，它既然比 4 要小，那真前缀和真后缀也只能在 abab 中找，即 abab 的最大匹配数，查表可得该值为 2。
     * 再往下就没有更短的匹配了。回顾完毕，来计算 ? 的值：既然末尾字母不是 z，那么就不能直接 6+1=7 了，我们回退到次大匹配 abab，
     * 刚好 abab 之后的 a 与末尾的 a 匹配，所以 ? 处的最大匹配数为 5。
     *
     * 构造模式串 pattern 的最大匹配数表
     */
    static int[] calculateMaxMatchLengths(String pattern) {
        int[] maxMatchLengths = new int[pattern.length()];
        int maxLength = 0;
        for (int i = 1; i < pattern.length(); i++) {
            while (maxLength > 0 && pattern.charAt(maxLength) != pattern.charAt(i)) {
                maxLength = maxMatchLengths[maxLength - 1];
            }
            if (pattern.charAt(maxLength) == pattern.charAt(i)) {
                maxLength++;
            }
            maxMatchLengths[i] = maxLength;
        }
        return maxMatchLengths;
    }
}
