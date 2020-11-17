package com.lbt.算法.链表.环型链表_141;


import java.util.HashMap;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/17 23:45
 * 第141题：给定一个链表，判断链表中是否有环。为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的
 * 位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。
 * 示例1：
 * 输入：head = [3,2,0,-4], pos = 1输出：true解释：链表中有一个环，其尾部连接到第二个节点。
 * 示例2：
 * 输入：head = [1,2], pos = 0输出：true解释：链表中有一个环，其尾部连接到第一个节点。
 * 示例3：
 * 输入：head = [1], pos = -1输出：false解释：链表中没有环。
 */
public class Solution {
    //最简单的思路：
    // 思路：通过hash表来检测节点之前是否被访问过，来判断链表是否成环。这是最容易想到的一种题解了。过于简单，直接上代码：
    //思路一：
    public boolean hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (head!=null){
            if (map.get(head)!=null){
                return true;
            }
            map.put(head,1);
            head = head.next;
        }
        return false;
    }

    /**
     * 双指针解法
     * 思路来源：先想象一下，两名运动员以不同速度在跑道上进行跑步会怎么样？相遇！好了，这道题你会了。
     * 解题方法：通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
     * @param head
     * @return
     */
    public boolean hasCycle1(ListNode head) {
        if (head == null){
            return false;
        }
        ListNode fast = head.next;
        while (fast!=null && head!=null && fast.next!=null){
            if (fast == head){
                return true;
            }
            fast = fast.next.next;
            head = head.next;
        }
        return false;
    }

    /**
     * func hasCycle(head *ListNode) bool {
     *     if head == nil {
     *         return false
     *     }
     *     //有些同学不理解为什么初始化快指针在head.Next的位置
     *     //我们可以认为是从起跑线开始的！
     *     fast := head.Next
     *     for fast != nil && head != nil && fast.Next != nil {
     *         if fast == head {   // 快慢指针相遇，今生的擦肩而过
     *             return true
     *         }
     *         fast = fast.Next.Next
     *         head = head.Next
     *     }
     *     return false
     * }
     */



}
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}