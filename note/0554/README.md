# [Brick Wall][title]

## Description

There is a brick wall in front of you. The wall is rectangular and has several rows of bricks. The bricks have the same height but different width. You want to draw a vertical line from the **top** to the **bottom** and cross the **least** bricks.

The brick wall is represented by a list of rows. Each row is a list of integers representing the width of each brick in this row from left to right.

If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.

**You cannot draw a line just along one of the two vertical edges of the wall, in which case the line will obviously cross no bricks.**

**Example:**

```
Input:
[[1,2,2,1],
 [3,1,2],
 [1,3,2],
 [2,4],
 [3,1,2],
 [1,3,1,1]]
Output: 2
```

Explanation:
![img](https://leetcode.com/static/images/problemset/brick_wall.png)

**Note:**

1. The width sum of bricks in different rows are the same and won't exceed INT_MAX.

2. The number of bricks in each row is in range [1,10,000]. The height of wall is in range [1,10,000]. Total number of bricks of the wall won't exceed 20,000.

**Tags:** Hash Table


## 思路

题意根据图示已经描述得很清楚了，就是在从底部到顶部，求最少交叉的数量，我们可以把每堵墙可以穿过的地方保存到哈希表中，每次遇到哈希表中的值加一，代表就是这条路不用交叉的数量，最终我们可以算出不用交叉的最大值，让总墙数减去其值就是最少交叉的数量。

```java
class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int width = 0, max = 0;
        for (List<Integer> sub : wall) {
            int p = 0;
            for (int i = 0, len = sub.size() - 1; i < len; ++i) {
                p += sub.get(i);
                Integer v = map.get(p);
                map.put(p, (v == null ? 0 : v) + 1);
            }
        }
        for (Integer integer : map.values()) {
            if (integer > max) max = integer;
        }
        return wall.size() - max;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/brick-wall
[ajl]: https://github.com/Blankj/awesome-java-leetcode
