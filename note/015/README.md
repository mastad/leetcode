[15. 3Sum](https://leetcode.com/problems/3sum/)

**题目**

找到三数之和为 0 的组合

例子:

>Input: [-1, 0, 1, 2, -1, -4]

>Output:[
          [-1, 0, 1],
          [-1, -1, 2]
        ]



**思路**

直接穷举了所有的组合，感觉这个解法不咋地

代码:

``` java
   private List<List<Integer>> threeSum(int[] nums) {
           List<List<Integer>> result = new ArrayList<>();
           Integer lastOne = -65535;
           Integer lastTwo = -65535;
           Arrays.sort(nums);
           for (int i = 0; i < nums.length - 2; i++) {
               int one = nums[i];
               //去重
               if (one == lastOne) {
                   continue;
               }
               lastOne = -65535;
               for (int j = i + 1; j < nums.length - 1; j++) {
                   int two = nums[j];
                   //去重
                   if (two == lastTwo) {
                       continue;
                   }
                   lastTwo = -65535;
                   //二分查找
                   int threeIndex = -1;
                   int start = j + 1;
                   int end = nums.length - 1;
                   int khey = -(one + two);
                   int mid;
                   while (start <= end) {
                       mid = start + (end - start) / 2;
                       if (nums[mid] < khey)
                           start = mid + 1;
                       else if (nums[mid] > khey)
                           end = mid - 1;
                       else {
                           threeIndex = mid;
                           break;
                       }
                   }
                   if (threeIndex != -1) {
                       int three = nums[threeIndex];
                       if (one + two + three == 0) {
                           List<Integer> r = new ArrayList<>();
                           r.add(one);
                           r.add(two);
                           r.add(three);
                           result.add(r);
                           lastOne = one;
                           lastTwo = two;
                       }
                   }
               }
   
           }
           return result;
       }
```


