[169. Majority Element](https://leetcode.com/problems/majority-element/)

**题目**

判断出现超过一半的元素

例子:

>Input: [3,2,3]

>Output: 3

>Input: [2,2,1,1,1,2,2]

>Output: 2

**思路**

先计算出半数是多少。再使用map做记录，一旦超过半数则返回。

代码:

``` java
       public int majorityElement(int[] nums) {
   
           Map<Integer, Integer> map = new HashMap();
           int n = nums.length % 2 == 1 ? nums.length / 2 + 1 : nums.length / 2;
   
           for (int i = 0; i < nums.length; i++) {
               int key = nums[i];
               Integer times = map.get(key);
               if (times == null) {
                   map.put(key, 1);
               } else {
                   times += 1;
                   if (times >= n) {
                       return nums[i];
                   }
                   map.put(key, times);
               }
           }
   
           return nums[0];
   
       }
```


