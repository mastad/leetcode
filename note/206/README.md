[Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

**题目**

反转一个单向链表。

例子:

> Input: 1->2->3->4->5->NULL
> Output: 5->4->3->2->1->NULL



**思路**

```ListNode head```是一个单向链表,我们需要生成一个新的链表 ```ListNode pre```，在 ``` head ``` 遍历的过程中将值反向插入到```pre```。这里面有一点需要注意，一定需要一个临时的链表去缓存 ```head``` 的next。

代码：
``` java

    public  ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode current = head;
        while (current != null) {
            ListNode temp = current.next;
            current.next = pre;
            pre = current;
            current = temp;
        }
        return pre;
    }

```

**复杂度**

时间复杂度：O(n)
空间复杂度；O(1)


