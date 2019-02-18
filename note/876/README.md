[ Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)


**题目**

查找链表的中间结点

例子:
> input 1->2->3->4->5
> output 3->4->5.


**思路**

单向链表不好处理的时侯，就用两个指针。这道题也是，两个指针：快指针和慢指针。快指针的速度是慢指针的两倍，快指针走到尾部时，慢指针就刚好在链表中间。

代码:

``` java
    public ListNode middleNode(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast.next==null){
            slow = slow.next;
        }
        return slow;

    }
```