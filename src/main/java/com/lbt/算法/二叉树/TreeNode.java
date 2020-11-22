package com.lbt.算法.二叉树;

/**
 * @Author LiBiTong
 * @Description
 * @Date 2020/11/22 11:40
 */
public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;
    public TreeNode() {}
    public TreeNode(int x) { val = x; }
    public TreeNode(int x, TreeNode left, TreeNode right) {
        val = x;
        left = left;
        right = right;
    }
}
