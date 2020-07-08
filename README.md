# awesome-java-leetcode

我如今是一名 Android Developer，大学的我曾是一名 ACMer，我一直认为数据结构和算法是作为一名程序员必须掌握和善于利用的，为了不让数据结构和算法淡出我的记忆，所以我打算重拾 LeetCode 之 Algorithm，语言选择的是 Java，题库会一点点完善起来，按简单，中等，困难分类，相应难度下按题号排序，源代码在 [src][src] 目录中，相关解题都在 [note][note] 目录中，想要学习数据结构和算法或打算刷 LeetCode 的小伙伴们欢迎 star 哦。

如今有机会面试 Facebook，附上 LeetCode 上 Facebook 的面试题目序号，希望可以帮助到以后想入 Facebook 的小伙伴:-)

```
1,10,13,15,17,20,23,25,26,28,33,38,43,44,49,50,56,57,67,68,69,71,75,76
78,79,80,85,88,90,91,98,102,117,121,125,127,128,133,139,146,157,158,161
168,173,200,206,208,209,210,211,215,218,221,234,235,236,238,252,253,257
261,265,269,273,274,275,277,278,282,283,285,286,297,301,311,314,325,334
341,377,380,398,404,410,461,477,494,523,525,534,535,543,554
```

如果想知道更多公司 LeetCode 面试题，可以参看 [Companies.md][companies]。

附上镇楼诗：

> 明有科举八股，今有 LeetCode。  
> 八股定格式而取文采心意，LeetCode 定题目且重答案背诵。  
> 美其名曰："practice makes perfect."  
> 为何今不如古？  
> 非也非也，  
> 科举为国取士，LeetCode 为 Google 筛码工，各取所需也。  

## Easy

| #    | Title                                                             | Tag                                               |
| :--- | :---------------------------------------------------------------- | :------------------------------------------------ |
| 1    | [Two Sum][0001]                                                   | Array, Hash Table                                 |
| 7    | [Reverse Integer][0007]                                           | Math                                              |
| 9    | [Palindrome Number][0009]                                         | Math                                              |
| 13   | [Roman to Integer][0013]                                          | Math, String                                      |
| 14   | [Longest Common Prefix][0014]                                     | String                                            |
| 16.11| [跳水板(Diving Board LCCI)][16_11]                                 | 递归、记忆化                                       |
| 20   | [Valid Parentheses][0020]                                         | Stack, String                                     |
| 21   | [Merge Two Sorted Lists][0021]                                    | Linked List                                       |
| 26   | [Remove Duplicates from Sorted Array][0026]                       | Array, Two Pointers                               |
| 27   | [Remove Element][0027]                                            | Array, Two Pointers                               |
| 28   | [Implement strStr()][0028]                                        | Two Pointers, String                              |
| 35   | [Search Insert Position][0035]                                    | String                                            |
| 38   | [Count and Say][0038]                                             | String                                            |
| 53   | [Maximum Subarray][0053]                                          | Array, Divide and Conquer, Dynamic Programming    |
| 58   | [Length of Last Word][0058]                                       | String                                            |
| 66   | [Plus One][0066]                                                  | Array, Math                                       |
| 67   | [Add Binary][0067]                                                | Math, String                                      |
| 69   | [Sqrt(x)][0069]                                                   | Binary Search, Math                               |
| 70   | [Climbing Stairs][0070]                                           | Dynamic Programming                               |
| 83   | [Remove Duplicates from Sorted List][0083]                        | Linked List                                       |
| 88   | [Merge Sorted Array][0088]                                        | Array, Two Pointers                               |
| 100  | [Same Tree][0100]                                                 | Tree, Depth-first Search                          |
| 101  | [Symmetric Tree][0101]                                            | Tree, Depth-first Search, Breadth-first Search    |
| 104  | [Maximum Depth of Binary Tree][0104]                              | Tree, Depth-first Search                          |
| 107  | [Binary Tree Level Order Traversal II][107]                       | Tree, Breadth-first Search                        |
| 108  | [Convert Sorted Array to Binary Search Tree][0108]                | Tree, Depth-first Search                          |
| 110  | [Balanced Binary Tree][0110]                                      | Tree, Depth-first Search                          |
| 111  | [Minimum Depth of Binary Tree][0111]                              | Tree, Depth-first Search, Breadth-first Search    |
| 112  | [Path Sum][0112]                                                  | Tree, Depth-first Search                          |
| 118  | [Pascal's Triangle][0118]                                         | Array                                             |
| 119  | [Pascal's Triangle II][0119]                                      | Array                                             |
| 121  | [Best Time to Buy and Sell Stock][0121]                           | Array, Dynamic Programmin                         |
| 122  | [Best Time to Buy and Sell Stock II][0122]                        | Array, Greedy                                     |
| 543  | [Diameter of Binary Tree][0543]                                   | Tree                                              |

## Medium

| #    | Title                                                             | Tag                                               |
| :--- | :---------------------------------------------------------------- | :------------------------------------------------ |
| 2    | [Add Two Numbers][0002]                                           | Linked List, Math                                 |
| 3    | [Longest Substring Without Repeating Characters][0003]            | Hash Table, Two Pointers, String                  |
| 5    | [Longest Palindromic Substring][0005]                             | String, Dynamic Programming                       |
| 6    | [ZigZag Conversion][0006]                                         | String                                            |
| 8    | [String to Integer (atoi)][0008]                                  | Math, String                                      |
| 11   | [Container With Most Water][0011]                                 | Array, Two Pointers                               |
| 12   | [Integer to Roman][0012]                                          | Math, String                                      |
| 15   | [3Sum][0015]                                                      | Array, Two Pointers                               |
| 15   | [3Sum Closest][0016]                                              | Array, Two Pointers                               |
| 17   | [Letter Combinations of a Phone Number][0017]                     | String, Backtracking                              |
| 18   | [4Sum][0018]                                                      | Array, Hash Table, Two Pointers                   |
| 19   | [Remove Nth Node From End of List][0019]                          | Linked List, Two Pointers                         |
| 22   | [Generate Parentheses][0022]                                      | String, Backtracking                              |
| 24   | [Swap Nodes in Pairs][0024]                                       | Linked List                                       |
| 29   | [Divide Two Integers][0029]                                       | Math, Binary Search                               |
| 33   | [Search in Rotated Sorted Array][0033]                            | Arrays, Binary Search                             |
| 43   | [Multiply Strings][0043]                                          | Math, String                                      |
| 49   | [Group Anagrams][0049]                                            | Hash Table, String                                |
| 50   | [Pow(x, n)][0050]                                                 | Math, Binary Search                               |
| 56   | [Merge Intervals][0056]                                           | Array, Sort                                       |
| 63   | [不同路径 II(Unique Paths II)][0063]                               | 数组、动态规划                                      |
| 209  | [长度最小的子数组(Minimum Size Subarray Sum)][0209]                 | 数组、双指针、二分查找                               |
| 215  | [数组中的第K个最大元素(Kth Largest Element in an Array)][0215]       | 堆、分治算法                                       |
| 554  | [Brick Wall][0554]                                                | Hash Table                                        |
| 1014 | [最佳观光组合(Best Sightseeing Pair)][1014]                         | 数组                                              |

## Hard

| #    | Title                                                             | Tag                                               |
| :--- | :---------------------------------------------------------------- | :------------------------------------------------ |
| 4    | [Median of Two Sorted Arrays][0004]                               | Array, Binary Search, Divide and Conquer          |
| 10   | [Regular Expression Matching][0010]                               | String, Dynamic Programming, Backtracking         |
| 23   | [Merge k Sorted Lists][0023]                                      | Linked List, Divide and Conquer, Heap             |
| 25   | [Reverse Nodes in k-Group][0025]                                  | Linked List                                       |
| 30   | [Substring with Concatenation of All Words][0030]                 | Hash Table, Two Pointers, String                  |
| 44   | [Wildcard Matching][0044]                                         | String, Dynamic Programming, Backtracking, Greedy |
| 57   | [Insert Interval][0057]                                           | Array, Sort                                       |
| 68   | [Text Justification][0068]                                        | String                                            |
| 1028 | [从先序遍历还原二叉树(Recover a Tree From Preorder Traversal)][1028] | 树、深度优先搜索                                    |

## 打个小广告

欢迎加入我的知识星球「**[基你太美](https://t.zsxq.com/FmeqfYF)**」，我会在星球中分享 [AucFrame](https://blankj.com/2019/07/22/auc-frame/) 框架、大厂面经、[AndroidUtilCode](https://github.com/Blankj/AndroidUtilCode) 更详尽的说明...一切我所了解的知识，你可以通过支付进入我的星球「**[基你太美](https://t.zsxq.com/FmeqfYF)**」进行体验，加入后优先观看星球中精华的部分，如果觉得星球的内容对自身没有收益，你可以自行申请退款退出星球，也没必要加我好友；**如果你已确定要留在我的星球，可以通过扫描如下二维码（备注：基你太美+你的星球昵称）加我个人微信，方便我后续拉你进群(PS：进得越早价格越便宜)。**

![我的二维码](https://raw.githubusercontent.com/Blankj/AndroidUtilCode/master/art/wechat.png)


[src]: https://github.com/Blankj/awesome-java-leetcode/tree/master/src
[note]: https://github.com/Blankj/awesome-java-leetcode/tree/master/note
[companies]: https://github.com/Blankj/awesome-java-leetcode/blob/master/Companies.md

[0001]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0001/README.md
[0007]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0007/README.md
[0009]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0009/README.md
[0013]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0013/README.md
[0014]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0014/README.md
[16_11]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/16_11/README.md
[0020]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0020/README.md
[0021]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0021/README.md
[0026]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0026/README.md
[0027]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0027/README.md
[0028]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0028/README.md
[0035]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0035/README.md
[0038]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0038/README.md
[0053]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0053/README.md
[0058]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0058/README.md
[0066]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0066/README.md
[0067]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0067/README.md
[0069]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0069/README.md
[0070]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0070/README.md
[0083]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0083/README.md
[0088]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0088/README.md
[0100]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0100/README.md
[0101]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0101/README.md
[0104]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0104/README.md
[0107]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0107/README.md
[0108]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0108/README.md
[0110]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0110/README.md
[0111]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0111/README.md
[0112]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0112/README.md
[0118]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0118/README.md
[0119]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0119/README.md
[0121]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0121/README.md
[0122]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0122/README.md
[0543]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0543/README.md

[0002]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0002/README.md
[0003]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0003/README.md
[0005]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0005/README.md
[0006]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0006/README.md
[0008]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0008/README.md
[0011]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0011/README.md
[0012]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0012/README.md
[0015]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0015/README.md
[0016]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0016/README.md
[0017]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0017/README.md
[0018]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0018/README.md
[0019]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0019/README.md
[0022]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0022/README.md
[0024]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0024/README.md
[0029]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0029/README.md
[0033]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0033/README.md
[0043]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0043/README.md
[0049]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0049/README.md
[0050]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0050/README.md
[0056]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0056/README.md
[0063]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0063/README.md
[0209]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0209/README.md
[0215]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0215/README.md
[0554]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0554/README.md
[1014]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/1014/README.md

[0004]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0004/README.md
[0010]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0010/README.md
[0023]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0023/README.md
[0025]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0025/README.md
[0030]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0030/README.md
[0044]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0044/README.md
[0057]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0057/README.md
[0068]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/0068/README.md
[1028]: https://github.com/Blankj/awesome-java-leetcode/blob/master/note/1028/README.md