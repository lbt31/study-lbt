package com.lbt.算法.二叉树.二叉搜索树中的搜索_700;

import com.lbt.算法.二叉树.TreeNode;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 17:29
 * 第700题：二叉搜索树中的搜索
 * 第700题：给定二叉搜索树（BST）的根节点和一个值。你需要在BST中找到节点值等于给定值的节点。
 * 返回以该节点为根的子树。如果节点不存在，则返回 NULL。
 * 例如，给定二叉搜索树:
 *         4
 *        / \
 *       2   7
 *      / \
 *     1   3
 * 搜索: 2
 *
 * 你应该返回如下子树:
 *       2
 *      / \
 *     1   3

 * 在上述示例中，如果要找的值是 5，但因为没有节点值为 5，我们应该返回 NULL。
 *
 * 先复习一下，二叉搜索树（BST）的特性：
 * 1.若它的左子树不为空，则所有左子树上的值均小于其根节点的值
 *
 * 2.若它的右子树不为空，则所有右子树上的值均大于其根节点得值
 *
 * 3.它的左右子树也分别为二叉搜索树
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4,new TreeNode(2,new TreeNode(1,null,null),new TreeNode(3,null,null)),
                new TreeNode(7,null,null));
        TreeNode node = searchBST(root, 2);
        System.out.println(node);
    }

    /**
     * 递归与迭代的区别

     * 递归：重复调用函数自身实现循环称为递归；
     *
     * 迭代：利用变量的原值推出新值称为迭代，或者说迭代是函数内某段代码实现循环；
     */

    //递归
    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null){
            return null;
        }
        if (root.val>val){
            return searchBST(root.left,val);
        }
        if (root.val<val){
            return searchBST(root.right,val);
        }
        else {
            return root;
        }
    }

    //迭代
    public TreeNode searchBST01(TreeNode root, int val) {
        while (root != null) {
            if (root.val == val) {
                    return root;
                } else if (root.val > val) {
                    root = root.left;
                } else {
                    root = root.right;
                }
        }
        return null;
    }



}
