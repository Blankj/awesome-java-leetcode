# [Best Time to Buy and Sell Stock II][title]

## Description

Say you have an array for which the *i*<sup>th</sup> element is the price of a given stock on day *i*.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

**Tags:** Array, Greedy


## 思路

题意是给出一个数组代表每天的股票金额，在每天只能买或卖的情况下求出收益最高值，这...，这也太简单了吧，把所有相邻递增的值都加起来即可。

```java
class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; ++i) {
            if (prices[i] > prices[i - 1]) max += prices[i] - prices[i - 1];
        }
        return max;
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii
[ajl]: https://github.com/Blankj/awesome-java-leetcode
