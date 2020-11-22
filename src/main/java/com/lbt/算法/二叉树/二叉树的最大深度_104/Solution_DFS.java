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
public class Solution_DFS {

    //DFS：深度优先搜索算法（Depth First Search），
    // 对于二叉树而言，它沿着树的深度遍历树的节点，尽可能深的搜索树的分支，
    // 这一过程一直进行到已发现从源节点可达的所有节点为止。

    int maxLevel = 0;

    public int maxDepth(TreeNode root) {
        //递归结束条件
        if (root == null){
            return 0;
        }
        dfs(root,1);
        return maxLevel;
    }

    private void dfs(TreeNode root, int level) {
        if (root==null){
            return;
        }

        if (maxLevel< level){
            maxLevel = level;
        }
        dfs(root.left,level+1);
        dfs(root.right,level+1);
    }

}
