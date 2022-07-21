package com.hzf.leetcode._0814;

/**
 * 814. 二叉树剪枝
 * 给你二叉树的根结点 root ，此外树的每个结点的值要么是 0 ，要么是 1 。
 * 返回移除了所有不包含 1 的子树的原二叉树。
 * 节点 node 的子树为 node 本身加上所有 node 的后代。
 *
 * <a href="https://leetcode.cn/problems/binary-tree-pruning/">...</a>
 */
public class Solution {


    public TreeNode pruneTree(TreeNode root) {
        if (root == null) return null;
        root.right = pruneTree(root.right);
        root.left = pruneTree(root.left);
        if (root.right == null && root.left == null && root.val != 1) {
            return null;
        }
        return root;
    }




}
