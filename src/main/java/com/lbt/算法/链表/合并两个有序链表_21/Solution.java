package com.lbt.算法.链表.合并两个有序链表_21;

import java.util.List;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/16 23:48
 * 第21题：将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *示例：
 *
 * 输入：1->2->4, 1->3->4
 *
 * 输出：1->1->2->3->4->4
 *
 * 思路定义一个哨兵节点，首先让节点去连接两链表中最小的元素，然后比大小一次连接
 *
 * ***链表的题目，十道有九道会用到哨兵节点。所以我们先讲一下什么是哨兵节点。
 * 哨兵节点，捞干货，其实就是一个附加在原链表最前面用来简化边界条件的附加节点，它的值域不存储任何东西，只是为了操作方便而引入。
 */
public class Solution {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1,new ListNode(2, new ListNode(4,null)));
        ListNode l2 = new ListNode(1,new ListNode(3,new ListNode(4,null)));
        ListNode re = mergeTwoLists_1(l1,l2);
        while (re.next!=null){
            System.out.print(re.val+"  ");
            re = re.next;
        }
    }
    //非递归算法
    public static ListNode  mergeTwoLists(ListNode l1, ListNode l2) {
        //首先定义一个哨兵
        ListNode prehead  = new ListNode(-1);
        ListNode cur = prehead;
        //然后循环判断l1和l2的大小
        while(l1!=null && l2!=null){
            if (l1.val < l2.val){
                prehead.next = l1;
                l1 = l1.next;
            }else {
                prehead.next = l2;
                l2 = l2.next;
            }
            prehead = prehead.next;
        }
        //小的先连接到哨兵的下一节点
        if (l1==null){
            prehead.next = l2;
        }
        //当其中一个为空，直接将另一个链接到下一个
        if (l2==null) {
            prehead.next = l1;
        }
        return cur.next;
    }


    /**
     * 递归方法
     * @param l1
     * @param l2
     * @return
     */
    public static ListNode mergeTwoLists_1(ListNode l1, ListNode l2) {
        if (l1==null) return l2 ;
        if (l2==null) return l1 ;

        if (l1.val<l2.val) {
            l1.next = mergeTwoLists(l1.next,l2) ;
            return l1 ;
        }else {
            l2.next = mergeTwoLists(l1,l2.next) ;
            return  l2 ;
        }

    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
