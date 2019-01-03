[Add Two Numbers](https://leetcode.com/problems/add-two-numbers/)

**题目**

让两个不为空的链表相加、链表中没有负数，节点的值是逆序的且是单个的。

例子:

> Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
> Output: 7 -> 0 -> 8
> Explanation: 342 + 465 = 807


**思路**
这个题就是遍历链表的变种，新链表的取值来至于两个老的链表，节点相加小于 10 时直接变成新的节点值；但是如果大于等于 10 呢，我们可以利用一个计数器记录进位的情况。链表的题目主要是注意处理头尾的情况。头可以采用*哨兵*，尾部也需要特殊考虑进位的情况。需要注意的是相加的两个链表长度不一定一样。


代码:

``` java
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l = new ListNode(0);
        ListNode result = l;
        int adder = 0;

        while (l1 != null || l2 != null) {
            int a = l1 == null ? 0 : l1.val;
            int b = l2 == null ? 0 : l2.val;

            int sum = a + b + adder;
            adder = sum / 10;
            l.next = new ListNode(sum % 10);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            l = l.next;
        }

        if (adder != 0) {
            l.next = new ListNode(1);
        }
        return result.next;
    }
```



