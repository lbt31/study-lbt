package com.lbt.算法.链表.排序链表_148;

import com.lbt.算法.链表.ListNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/21 17:42
 * 148. 排序链表
 *
 * 给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 * 进阶：
 *
 * 你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 * 输入：head = [4,2,1,3]
 * 输出：[1,2,3,4]
 * 输入：head = [-1,5,3,4,0]
 * 输出：[-1,0,3,4,5]
 * 输入：head = []
 * 输出：[]
 *
 * 提示：
 *
 * 链表中节点的数目在范围 [0, 5 * 10^4] 内
 * -105 <= Node.val <= 105
 */
public class Solution {

    public static void main(String[] args) {
        ListNode head = new ListNode(9,new ListNode(8,new ListNode(7,new ListNode(6,
                new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1,null)))))))));
        ListNode re = sortList(head);
        while (re!=null){
            System.out.print(re.val+"  ");
            re = re.next;
        }
    }

    public static ListNode sortList(ListNode head) {
        return mergeSort(head);

    }

    /**
     *  归并排序:: O(NlogN)
     * 将一个大的无序数组有序，我们可以把大的数组分成两个，然后对这两个数组分别进行排序，之后在把这两个数组合并成一
     * 个有序的数组。由于两个小的数组都是有序的，所以在合并的时候是很快的。
     *
     * 通过递归的方式将大的数组一直分割，直到数组的大小为 1，此时只有一个元素，那么该数组就是有序的了，之后再把两
     * 个数组大小为1的合并成一个大小为2的，再把两个大小为2的合并成4的 ….. 直到全部小的数组合并起来
      */
    private static ListNode mergeSort(ListNode head){
        // 如果没有结点/只有一个结点，无需排序，直接返回
        if (head==null||head.next==null) return head;
        // 快慢指针找出中位点
        ListNode slowp=head,fastp=head.next.next,l,r;
        while (fastp!=null&&fastp.next!=null){
            slowp=slowp.next;
            fastp=fastp.next.next;
        }
        // 对右半部分进行归并排序
        r=mergeSort(slowp.next);
        // 链表判断结束的标志：末尾节点.next==null
        slowp.next=null;
        // 对左半部分进行归并排序
        l=mergeSort(head);
        return mergeList(l,r);
    }
    // 合并链表
    private  static ListNode mergeList(ListNode l,ListNode r){
        // 临时头节点
        ListNode tmpHead=new ListNode(-1);
        ListNode p=tmpHead;
        while (l!=null&&r!=null){
            if (l.val<r.val){
                p.next=l;
                l=l.next;
            }else {
                p.next=r;
                r=r.next;
            }
            p=p.next;
        }
        p.next= l==null?r:l;
        return tmpHead.next;
    }


}
