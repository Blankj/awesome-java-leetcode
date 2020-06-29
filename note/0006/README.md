# [ZigZag Conversion][title]

## Description

The string `"PAYPALISHIRING"` is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

```
P   A   H   N
A P L S I I G
Y   I   R
```

And then read line by line: `"PAHNAPLSIIGYIR"`

Write the code that will take a string and make this conversion given a number of rows:

```
string convert(string s, int numRows);
```

**Example 1:**

```
Input: s = "PAYPALISHIRING", numRows = 3
Output: "PAHNAPLSIIGYIR"
```

**Example 2:**

```
Input: s = "PAYPALISHIRING", numRows = 4
Output: "PINALSIGYAHRPI"
Explanation:

P     I    N
A   L S  I G
Y A   H R
P     I
```

**Tags:** String


## 思路 0

题意是让你把字符串按波浪形排好，然后返回横向读取的字符串。

听不懂的话，看下面的表示应该就明白了：

```
0                           2n-2                        4n-4
1                    2n-3   2n-1                 4n-5   4n-5
2              2n-4         2n               4n-6       .
.           .               .             .             .
.       n+1                 .          3n-1             .
n-2   n                     3n-4   3n-2                 5n-6
n-1                         3n-3                        5n-5
```

那么我们可以根据上面找规律，可以看到波峰和波谷是单顶点的，它们周期是 `2 * (n - 1)`，单独处理即可；中间的部分每个周期会出现两次，规律很好找，留给读者自己想象，不懂的可以结合以下代码。

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length();
        char[] chars = s.toCharArray();
        int cycle = 2 * (numRows - 1);
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < len; j += cycle) {
            sb.append(chars[j]);
        }
        for (int i = 1; i < numRows - 1; i++) {
            int step = 2 * i;
            for (int j = i; j < len; j += step) {
                sb.append(chars[j]);
                step = cycle - step;
            }
        }
        for (int j = numRows - 1; j < len; j += cycle) {
            sb.append(chars[j]);
        }
        return sb.toString();
    }
}
```


## 思路 1

另外一种思路就是开辟相应行数的 `StringBuilder` 对象，然后模拟波浪生成的样子分别插入到相应的 `StringBuilder` 对象，比较直白简单，具体代码如下。

```java
class Solution {
    public String convert(String s, int numRows) {
        if (numRows <= 1) return s;
        int len = s.length();
        char[] chars = s.toCharArray();
        StringBuilder[] sbs = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            sbs[i] = new StringBuilder();
        }
        int i = 0;
        while (i < len) {
            for (int j = 0; j < numRows && i < len; ++j) {
                sbs[j].append(chars[i++]);
            }
            for (int j = numRows - 2; j >= 1 && i < len; --j) {
                sbs[j].append(chars[i++]);
            }
        }
        for (i = 1; i < numRows; i++) {
            sbs[0].append(sbs[i]);
        }
        return sbs[0].toString();
    }
}
```


## 结语

如果你同我一样热爱数据结构、算法、LeetCode，可以关注我 GitHub 上的 LeetCode 题解：[awesome-java-leetcode][ajl]



[title]: https://leetcode.com/problems/zigzag-conversion
[ajl]: https://github.com/Blankj/awesome-java-leetcode
