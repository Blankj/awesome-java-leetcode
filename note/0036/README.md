# [Valid Sudoku][title]

## Description

Determine if a `9 x 9` Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

1. Each row must contain the digits `1-9` without repetition.
2. Each column must contain the digits `1-9` without repetition.
3. Each of the nine `3 x 3` sub-boxes of the grid must contain the digits `1-9` without repetition.

**Tags:** Array, Hash Table, Matrix

## Solution 0 - HashSet

Use three sets of HashSets to track seen digits for each row, column, and 3x3 box.

```java
class Solution {
    public boolean isValidSudoku(char[][] board) {
        java.util.Set<String> seen = new java.util.HashSet<>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char c = board[i][j];
                if (c == '.') continue;
                String row = "row" + i + c;
                String col = "col" + j + c;
                String box = "box" + (i / 3) + (j / 3) + c;
                if (!seen.add(row) || !seen.add(col) || !seen.add(box)) {
                    return false;
                }
            }
        }
        return true;
    }
}
```

[title]: https://leetcode.com/problems/valid-sudoku
