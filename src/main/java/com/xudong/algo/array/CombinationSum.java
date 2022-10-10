package com.xudong.algo.array;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        combinationSum2(candidates, target, new ArrayList<Integer>(), 0);
        return result;
    }

    public void combinationSum2(int[] candidates, int target, List<Integer> comb, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(comb));
            return;
        }
        if (target < 0) return;
        for (int i = index ;i < candidates.length; i ++) {
            comb.add(candidates[i]);
            combinationSum2(candidates, target - candidates[i], comb, i);
            comb.remove(comb.size() - 1);
        }
    }
}
