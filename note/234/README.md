[Palindrome Linked List](https://leetcode.com/problems/palindrome-linked-list/)

**题目**

判断一个单向链表是否为回文

例子:

>Input: 1->2
>Output: false

>Input: 1->2->2->1
>Output: true

**思路**

构建一个反向的链表，如果是回文正向和反向的应该一摸一样。比较的时候不需要全部遍历，遍历一半就可以了。

代码:

``` java
    public boolean isPalindrome(ListNode head) {

        if (head == null) {
            return false;
        }
        ListNode pre = null;
        ListNode current = head;
        int n = 0;

        while (current != null) {
            ListNode temp = new ListNode(current.val);
            temp.next = pre;
            pre = temp;
            current = current.next;
            n++;
        }


        while (n > 0) {
            if (head.val != pre.val) {
                return false;
            }
            head = head.next;
            pre = pre.next;
            n -= 2;
        }

        return true;
    }
```



