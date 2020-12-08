package com.lbt.算法.二叉树.二叉树后续遍历;

import com.lbt.算法.二叉树.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Stack;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/12/4 15:35
 *
 */
public class Solution {

    //后续：左右根
    public List<Integer> postSort(TreeNode head) {
        if (head == null) {
            return Collections.emptyList();
        }
        List<Integer> list = new ArrayList<>();

        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> stack1 = new Stack<>();
        stack.push(head);
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();

            stack1.push(node);

            if (node.left != null) {
                stack.push(node.left);
            }

            if (node.right != null) {
                stack.push(node.right);
            }
        }
        while (!stack1.isEmpty()) {
            list.add(stack.pop().val);
        }
        return list;
    }


}
