package com.lbt.算法.链表.删除链表倒数第N个节点;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/16 23:48
 * 第19题：给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
 *示例：
 *  给定一个链表: 1->2->3->4->5, 和 n = 2.
 * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 *
 * 思路定义一个哨兵节点，首先让节点去连接两链表中最小的元素，然后比大小一次连接
 *
 * ***链表的题目，十道有九道会用到哨兵节点。所以我们先讲一下什么是哨兵节点。
 * 哨兵节点，捞干货，其实就是一个附加在原链表最前面用来简化边界条件的附加节点，它的值域不存储任何东西，只是为了操作方便而引入。
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(4,new ListNode(5,new ListNode(6,null)))));
        ListNode re = removeNthFromEnd(l1,2);
        System.out.println(re);
    }
    public static ListNode removeNthFromEnd(ListNode head, int n) {

        return null;

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
