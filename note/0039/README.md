# [Combination Sum][title]

## Description

Given an array of **distinct** integers `candidates` and a target integer `target`, return a list of all **unique combinations** of `candidates` where the chosen numbers sum to `target`. You may return the combinations in **any order**. The **same** number may be chosen from `candidates` an **unlimited number of times**.

**Example:**
```
Input: candidates = [2,3,6,7], target = 7
Output: [[2,2,3],[7]]
```

**Tags:** Array, Backtracking

## Solution 0 - Backtracking

Sort candidates, then use backtracking. At each step, try each candidate starting from the current index (allow reuse). Prune if remaining target < 0.

```java
class Solution {
    public java.util.List<java.util.List<Integer>> combinationSum(int[] candidates, int target) {
        java.util.List<java.util.List<Integer>> result = new java.util.ArrayList<>();
        java.util.Arrays.sort(candidates);
        backtrack(result, new java.util.ArrayList<>(), candidates, target, 0);
        return result;
    }

    private void backtrack(java.util.List<java.util.List<Integer>> result,
                           java.util.List<Integer> current,
                           int[] candidates, int remaining, int start) {
        if (remaining == 0) {
            result.add(new java.util.ArrayList<>(current));
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (candidates[i] > remaining) break;
            current.add(candidates[i]);
            backtrack(result, current, candidates, remaining - candidates[i], i);
            current.remove(current.size() - 1);
        }
    }
}
```

[title]: https://leetcode.com/problems/combination-sum
