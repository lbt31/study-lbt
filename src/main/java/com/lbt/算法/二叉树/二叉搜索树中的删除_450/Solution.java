package com.lbt.算法.二叉树.二叉搜索树中的删除_450;

import com.lbt.算法.二叉树.TreeNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 21:16
 * 第450题：二叉搜索树中的删除
 * 第450题：给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 说明：要求算法时间复杂度为 O(h)，h 为树的高度。
 * 示例:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7

 * 给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
 * 一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
 *     5
 *    / \
 *   4   6
 *  /     \
 * 2       7

 * 另一个正确答案是 [5,2,6,null,4,null,7]。
 *     5
 *    / \
 *   2   6
 *    \   \
 *     4   7
 */
public class Solution {
    /** 一般来说，删除节点可分为两个步骤：
     * 首先找到需要删除的节点；
     *
     * 如果找到了，删除它。
     * 我们要删除BST的一个节点，首先需要找到该节点。而找到之后，会出现三种情况。
     *
     * 待删除的节点左子树为空，让待删除节点的右子树替代自己。
     * 待删除的节点右子树为空，让待删除节点的左子树替代自己。
     * 如果待删除的节点的左右子树都不为空。我们需要找到比当前节点小的最大节点（前驱），来替换自己
     * 或者比当前节点大的最小节点（后继），来替换自己。
     * */

    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null)
            return null;
        //如果key大于根，则去右子树找
        if(root.val < key) {
            root.right = deleteNode(root.right, key);
        }
        //如果key小于根，则去左子树找
        else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }
        //相等，则找到
        else {
            //叶子节点直接删除
            if((root.left == null) && (root.right == null)) {
                return null;
            }
            //如果有左子树，则用前驱的值替代root的值，并在左子树中递归删除前驱节点
            if(root.left != null) {

                root.val = getPrev(root);
                root.left = deleteNode(root.left, root.val);
                //如果有右子树，则用后继的值替代root的值，并在右子树中递归删除后继节点
            } else if(root.right != null) {
                root.val = getNext(root);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    //找到root在中序遍历中的前驱
    public int getPrev(TreeNode p) {
        TreeNode q = p.left;
        while(q.right != null)
            q = q.right;
        return q.val;
    }

    //找到root在中序遍历中的后继
    public int getNext(TreeNode p) {
        TreeNode q = p.right;
        while(q.left != null)
            q = q.left;
        return q.val;
    }
}
