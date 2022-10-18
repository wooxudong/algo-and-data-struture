package com.xudong.algo.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PathSum {
    int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        traverse(root, targetSum);
        return res;
    }

    public List<Long> traverse(TreeNode node, int targetSum) {
        if (node == null) return Collections.emptyList();
        List<Long> leftTempsSums = traverse(node.left, targetSum);
        List<Long> rightTempSums = traverse(node.right, targetSum);

        ArrayList<Long> tempSums = new ArrayList<>();

        long val = node.val;
        leftTempsSums.forEach(tempSum -> {
            if (tempSum + val == targetSum) res++;
            tempSums.add(tempSum + node.val);
        });

        rightTempSums.forEach(tempSum -> {
            if (tempSum + val == targetSum) res++;
            tempSums.add(tempSum + node.val);
        });

        if (node.val == targetSum) res++;
        tempSums.add(val);

        return tempSums;
    }
}
