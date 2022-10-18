package com.xudong.algo.tree;

public class DiameterOfTree {
    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) return 0;

        int ld = diameterOfBinaryTree(root.left);
        int rd = diameterOfBinaryTree(root.right);

        int selfDiameter = height(root.left) + height(root.right);
        return Math.max(selfDiameter, Math.max(ld, rd));
    }

    int height(TreeNode node) {
        if (node == null) return 0;
        else return Math.max(height(node.left) + 1, height(node.right) + 1);
    }
}
