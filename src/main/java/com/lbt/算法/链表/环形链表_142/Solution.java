package com.lbt.算法.链表.环形链表_142;


import com.lbt.算法.链表.ListNode;

import java.util.HashMap;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/17 23:45
 * 给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
 *
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中。
 * 说明：不允许修改给定的链表。
 * 进阶：
 * * 你是否可以使用 O(1) 空间解决此题？

 */
public class Solution {
    //最简单的思路：
    // 思路：通过hash表来检测节点之前是否被访问过，来判断链表是否成环。这是最容易想到的一种题解了。过于简单，直接上代码：
    //思路一：
    public ListNode hasCycle(ListNode head) {
        HashMap<ListNode,Integer> map = new HashMap<>();
        while (head!=null){
            if (map.get(head)!=null){
                return head;
            }
            map.put(head,1);
            head = head.next;
        }
        return null;
    }

    /**
     * 双指针解法
     * 思路来源：先想象一下，两名运动员以不同速度在跑道上进行跑步会怎么样？相遇！好了，这道题你会了。
     * 解题方法：通过使用具有 不同速度 的快、慢两个指针遍历链表，空间复杂度可以被降低至 O(1)。慢指针每次移动一步，而快指针每次移动两步。
     * @param head
     * @return
     */
    public ListNode hasCycle1(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
            //是否有环
            if(fast != null && fast == slow){
                //有环，找入环点
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }

        return null;
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
