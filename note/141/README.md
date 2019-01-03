[Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)

**题目**

检测单向链表中的环。

例子

> Input: head = [3,2,0,-4], pos = 1
> Output: true

> Input: head = [1,2], pos = 0
> Output: true

> Input: head = [1], pos = -1
> Output: false

**思路**

想想有两个人，一个人跑得快一个人跑的慢。如果跑道是环形的，跑得快的总会从背后超过跑得慢的；如果跑道是条直线，跑得慢的永远也追不上跑得快的。

代码：

``` java
    public  boolean hasCycle(ListNode list) {
        if (list == null) return false;

        ListNode fast = list.next;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }
```


**时间复杂度**
O(n)