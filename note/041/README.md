[41. First Missing Positive](https://leetcode.com/problems/first-missing-positive/)

**题目**

在无序的数组中，找到未出现的最小正数。要求时间复杂度 O(n),空间复杂度未常数级。

例子

>Input: [1,2,0]
>Output: 3

>Input: [3,4,-1,1]
>Output: 2

>Input: [7,8,9,11,12]
>Output: 1

**思路**

这道题的第一反应是使用位图来标记已经出现的数字，然后从左遍历得到最小正整数。但是此题对空间复杂度有要求，就是要求对数组原地操作。于是想到用数组的下标作为数字，对应的值作为标记。

代码：

``` java
    public int firstMissingPositive(int[] nums) {

        int n = nums.length;
        for (int i = 0; i < n; i++) {
            if (nums[i] <= 0 || nums[i] > n) {
                nums[i] = n + 1;
            }
        }
        for (int i = 0; i < n; i++) {
            int num = Math.abs(nums[i]);
            if (num > n) {
                continue;
            }
            num--;
            if (nums[num] > 0) {
                nums[num] = -1 * nums[num];
            }
            print(nums);
        }

        for (int i = 0; i < n; i++) {
            if (nums[i] >= 0) {
                return i + 1;
            }
        }

        return n + 1;

    }
```

