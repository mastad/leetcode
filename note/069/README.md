[69. Sqrt(x)](https://leetcode.com/problems/sqrtx/)

**题目**

求平方根

例子

>Input: 4
>Output: 2

>Input: 8
>Output: 2


**思路**

只要反应过来是二分查找的变形就好解决了，本质是求小于等于给定值的最后一个元素。需要注意的是当给定值较大时，如：`Integer.MAX_VALUE`,需要通过位`运算求`中间值、利用`除运算`去判断平方和给定值的大小。

代码：

``` java
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int low = 1;
        int high = x;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            int n = x / mid;
            if (n == mid) {
                return mid;
            } else if (n < mid) {
                high = mid - 1;
            } else {
                int nr = x / (mid + 1);
                if (nr < (mid + 1)) {
                    return mid;
                } else {
                    low = mid + 1;
                }
            }
        }

        return mid;
    }
```

