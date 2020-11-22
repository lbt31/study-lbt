package com.lbt.算法.二叉树.验证二叉搜索树_98;

import com.lbt.算法.二叉树.TreeNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 15:24
 * 98.给定一个二叉树，判断其是否是一个有效的二叉搜索树。
 * 假设一个二叉搜索树具有如下特征：
 * 节点的左子树只包含小于当前节点的数。
 * 节点的右子树只包含大于当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * 示例 1:

 *
 * 输入:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * 输出: false
 *
 * 解释: 输入为: [5,1,4,null,null,3,6]。
 *
 * 根节点的值为 5 ，但是其右子节点值为 4 。
 */
public class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root==null){
            return true;
        }
        return isBST(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }

    private boolean isBST(TreeNode node, long minValue, long maxValue) {
        if (node == null){
            return true;
        }
        if (node.val<=minValue || node.val >= maxValue){
            return false;
        }
        return isBST(node.left,minValue,node.val) && isBST(node.right,node.val,maxValue);
    }
}
