package com.xudong.algo.tree;

public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        if( Math.abs(heightTree(root.left) - heightTree(root.right)) > 1) return false;
        else return isBalanced(root.left) && isBalanced(root.right);
    }


    private int heightTree(TreeNode root) {
        if (root == null) return 0;
        return Math.max(heightTree(root.left), heightTree(root.right)) + 1;
    }

}
