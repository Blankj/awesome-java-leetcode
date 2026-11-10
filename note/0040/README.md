# [Combination Sum II][title]

## Description

Given a collection of candidate numbers (`candidates`) and a target number (`target`), find all unique combinations in `candidates` where the candidate numbers sum to `target`. Each number in `candidates` may only be used **once** in the combination.

**Example:**
```
Input: candidates = [10,1,2,7,6,1,5], target = 8
Output: [[1,1,6],[1,2,5],[1,7],[2,6]]
```

**Tags:** Array, Backtracking

## Solution 0 - Backtracking with Duplicate Skipping

Sort first. In backtracking, each element can only be used once (advance index). Skip duplicate elements at the same recursion level to avoid duplicate combinations.

```java
class Solution {
    public java.util.List<java.util.List<Integer>> combinationSum2(int[] candidates, int target) {
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
            if (i > start && candidates[i] == candidates[i - 1]) continue;
            current.add(candidates[i]);
            backtrack(result, current, candidates, remaining - candidates[i], i + 1);
            current.remove(current.size() - 1);
        }
    }
}
```

[title]: https://leetcode.com/problems/combination-sum-ii
