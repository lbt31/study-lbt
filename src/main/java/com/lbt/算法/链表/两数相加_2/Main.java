package com.lbt.算法.链表.两数相加_2;

import com.lbt.算法.链表.ListNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/18 0:50
 * 第2题：给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是
 * 按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
 *
 * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
 *
 * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 示例：
 *
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807

 */
public class Main {
    //加法肯定是从最低位到最高位进行相加，也就是这里的链表头到链表尾进行相加，
    // 所以需要遍历链表。我们令 l1 和 l2 指向两个链表的头，用一个 tmp 值来存储
    // 同一位相加的结果，以及一个新的链表来存储 tmp 的值。
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0,null);
        ListNode post = pre;
        int tmp = 0;
        while (l1!=null || l2!=null || tmp!=0){
            if (l1!=null){
                tmp += l1.val;
                l1 = l1.next;
            }
            if (l2!=null){
                tmp += l2.val;
                l2 = l2.next;
            }
            pre.next = new ListNode(tmp%10,null);
            tmp = tmp/10;
            pre = pre.next;
        }
        return post.next;

    }

    /**
     * func addTwoNumbers(l1 *ListNode, l2 *ListNode) *ListNode {
     *     list := &ListNode{0, nil}
     *     //这里用一个result，只是为了后面返回节点方便，并无他用
     *     result := list
     *     tmp := 0
     *     for l1 != nil || l2 != nil || tmp != 0 {
     *         if l1 != nil {
     *             tmp += l1.Val
     *             l1 = l1.Next
     *         }
     *         if l2 != nil {
     *             tmp += l2.Val
     *             l2 = l2.Next
     *         }
     *         list.Next = &ListNode{tmp % 10, nil}
     *         tmp = tmp / 10
     *         list = list.Next
     *     }
     *     return result.Next
     * }
     */
}
