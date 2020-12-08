package com.lbt.算法.链表.排序链表_148;

import com.lbt.算法.链表.ListNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/21 20:27
 * 148. 排序链表
 *
 *  给你链表的头结点 head ，请将其按 升序 排列并返回 排序后的链表 。
 *  进阶：
 *
 *  你可以在 O(n log n) 时间复杂度和常数级空间复杂度下，对链表进行排序吗？
 *  输入：head = [4,2,1,3]
 *  输出：[1,2,3,4]
 *  输入：head = [-1,5,3,4,0]
 *  输出：[-1,0,3,4,5]
 *  输入：head = []
 *  输出：[]
 *
 *  提示：
 *
 *  链表中节点的数目在范围 [0, 5 * 10^4] 内
 *  -105 <= Node.val <= 105
 */
public class QuickSolution02 {


    public static void main(String[] args) {
        ListNode head = new ListNode(9,new ListNode(8,new ListNode(7,new ListNode(6,
                new ListNode(5,new ListNode(4,new ListNode(3,new ListNode(2,new ListNode(1,null)))))))));
        ListNode re = sortList(head);
        while (re!=null){
            System.out.print(re.val+"  ");
            re = re.next;
        }
    }

    /**
     * 快排：O(Nlog2N)
     *  我们从数组中选择一个元素，我们把这个元素称之为中轴元素吧，然后把数组中所有小于中轴元素的元素放在其左边，
     *  所有大于或等于中轴元素的元素放在其右边，显然，此时中轴元素所处的位置的是有序的。也就是说，我们无需再移动中轴元素的位置。
     *
     *  从中轴元素那里开始把大的数组切割成两个小的数组(两个数组都不包含中轴元素)，接着我们通过递归的方式，让中轴元素左边的
     *  数组和右边的数组也重复同样的操作，直到数组的大小为1，此时每个元素都处于有序的位置。
     */

    //快速排序，不用临时链表
    public static ListNode sortList(ListNode head){
        ListNode a = new ListNode(0,head);
        sort(a.next,null);
        return a.next;
    }

    private static void sort(ListNode s, ListNode e) {
        if (s == e)return;
        int t = s.val;
        ListNode p0 = s;
        ListNode p1 = s.next;
        while(p1 != e){
            if (p1.val<t){
                p0 = p0.next;
                int temp = p0.val;
                p0.val = p1.val;
                p1.val = temp;
            }
            p1 = p1.next;
        }
        int temp = p0.val;
        p0.val = s.val;
        s.val = temp;
        sort(s, p0);
        sort(p0.next, e);
    }


}
