package com.xudong.algo.tree;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        solve(root);
        return root;
    }

    private void solve(TreeNode node) {
        if (node == null) return;
        switchLeftRight(node);
        solve(node.left);
        solve(node.right);
    }

    private void switchLeftRight(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }
}
