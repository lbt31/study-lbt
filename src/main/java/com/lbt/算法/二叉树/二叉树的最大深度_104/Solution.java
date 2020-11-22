package com.lbt.算法.二叉树.二叉树的最大深度_104;

import com.lbt.算法.二叉树.TreeNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 11:39
 * 第104题：给定一个二叉树，找出其最大深度。二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。

 * 示例：
 *
 * 给定二叉树 [3,9,20,null,null,15,7]，

 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 */
public class Solution {

    //递归的处理
    public int maxDepth(TreeNode root) {
        //递归结束条件
        if (root == null){
            return 0;
        }

        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }
}
