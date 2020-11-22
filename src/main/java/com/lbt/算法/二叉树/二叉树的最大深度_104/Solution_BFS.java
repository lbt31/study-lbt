package com.lbt.算法.二叉树.二叉树的最大深度_104;

import com.lbt.算法.二叉树.TreeNode;
import sun.reflect.generics.tree.Tree;

import java.util.LinkedList;
import java.util.Queue;

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
public class Solution_BFS {

    //BFS广度优先搜索:BFS，广度/宽度优先。其实就是从上到下，先把每一层遍历完之后再遍历一下一层

    // 使用双端队列deque（因为性能比另外两种Queue好得多），在大循环内对二叉树的每个层做一次遍历，
    // range(len(queue))使只遍历当前的层，每次大循环ans加1。由于每个节点仅访问一次，所以时间复杂度O(n)


    public int maxDepth(TreeNode root) {
        //递归结束条件
        if (root == null){
            return 0;
        }
        int level=0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            int size = queue.size();
            while(size>0){
                TreeNode node = queue.remove();
                if (node.left!=null){
                    queue.offer(node.left);
                }
                if (node.right!=null){
                    queue.offer(node.right);
                }
                size--;
            }
            level++;
        }
        return level;
    }


}
