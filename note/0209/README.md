# [长度最小的子数组][title]

## 题目描述

我们从二叉树的根节点 `root` 开始进行深度优先搜索。

在遍历中的每个节点处，我们输出 `D` 条短划线（其中 `D` 是该节点的深度），然后输出该节点的值。（_如果节点的深度为 `D`，则其直接子节点的深度为 `D + 1`。根节点的深度为 `0`）。_

如果节点只有一个子节点，那么保证该子节点为左子节点。

给出遍历输出 `S`，还原树并返回其根节点 `root`。

**示例 1：**

**![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/12/recover-a-tree-from-preorder-traversal.png)**

```
输入："1-2--3--4-5--6--7"
输出：[1,2,5,3,4,6,7]
```

**示例 2：**

**![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/12/screen-shot-2019-04-10-at-114101-pm.png)**

```
输入："1-2--3---4-5--6---7"
输出：[1,2,5,3,null,6,null,4,null,7]
```

**示例 3：**

![](https://assets.leetcode-cn.com/aliyun-lc-upload/uploads/2019/04/12/screen-shot-2019-04-10-at-114955-pm.png)

```
输入："1-401--349---90--88"
输出：[1,401,null,349,88,90]
```

**提示：**

*   原始树中的节点数介于 `1` 和 `1000` 之间。
*   每个节点的值介于 `1` 和 `10 ^ 9` 之间。

**标签：** 树、深度优先搜索


## 思路

直接暴力两层 for 循环肯定过不了关，我们把公式变化为 `(A[i] + i) + (A[j] - j)`，看到此应该就可以想到在每次遍历 `j` 时，只需要知道 `max(A[i] + i)` 即可。

```java
class Solution {

    public int maxScoreSightseeingPair(int[] A) {
        int ans = 0, cur = A[0] + 0;
        for (int j = 1; j < A.length; j++) {
            ans = Math.max(ans, cur + A[j] - j); // 计算当前最大得分
            cur = Math.max(cur, A[j] + j);       // 更新最大的 A[i] + i
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] A = new int[]{8, 1, 5, 2, 6};
        System.out.println(solution.maxScoreSightseeingPair(A));
    }
}

```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode-cn.com/problems/recover-a-tree-from-preorder-traversal
[ajl]: https://github.com/Blankj/awesome-java-leetcode
