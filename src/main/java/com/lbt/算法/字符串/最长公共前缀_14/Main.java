package com.lbt.算法.字符串.最长公共前缀_14;

/**
 * @Description
 * @Author libitong
 * @Date 2020/11/16 17:01
 * 题目14: 编写一个函数来查找字符串数组中的最长公共前缀。如果不存在公共前缀，则返回""
 *示例 1:
 *
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * 大概有这五种思路, 一般都会采用第四种, 但是耗时太多
 *
 * 1、所求的最长公共前缀子串一定是每个字符串的前缀子串。所以随便选择一个字符串作为标准，把它的前缀串，与其他所有字符串进行判断，看是否是它们所有人的前缀子串。这里的时间性能是O(m*n*m)。
 *
 * 2、列出所有的字符串的前缀子串，将它们合并后排序，找出其中个数为n且最长的子串。时间性能为O(n*m+m*n*log(m*n))
 *
 * 3、纵向扫描：从下标0开始，判断每一个字符串的下标0，判断是否全部相同。直到遇到不全部相同的下标。时间性能为O(n*m)。
 *
 * 4、横向扫描：前两个字符串找公共子串，将其结果和第三个字符串找公共子串……直到最后一个串。时间性能为O(n*m)。
 *
 * 5、借助trie字典树。将这些字符串存储到trie树中。那么trie树的第一个分叉口之前的单分支树的就是所求。
 */
public class Main {

    public static void main(String[] args) {
        String[] a = {"flower","flow","flight"};
        System.out.printf("最长公共前缀为%s",longestCommonPrefix(a));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length<0){
            return "";
        }
        if (strs.length==1){
            return strs[0];
        }
        String prefix = strs[0];
        for (int i =1;i<strs.length;i++){
            while(strs[i].indexOf(prefix) != 0){
                prefix=prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }

    /**
     * func longestCommonPrefix(strs []string) string {
     *     if len(strs) < 1 {
     *         return ""
     *     }
     *     prefix := strs[0]
     *     for _,k := range strs {
     *         for strings.Index(k,prefix) != 0 {
     *             if len(prefix) == 0 {
     *                 return ""
     *             }
     *             prefix = prefix[:len(prefix) - 1]
     *         }
     *     }
     *     return prefix
     * }
     */

}
