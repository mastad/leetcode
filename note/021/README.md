[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

**题目**

合并两个有序链表，并保证新的链表也是有序的。

例子：

> Input: 1->2->4, 1->3->4
> Output: 1->1->2->3->4->4


**思路**

合并两个链表本身没有太大难度。只是需要知道两个小技巧：1.一个链表循环到尾节点后，另一个就直接拼接到新链表就可以结束了；2.使用*哨兵*处理头问题，减少非空判断。

代码：

``` java
ListNode watcher = new ListNode(0);
        ListNode node = watcher;

        while (true) {

            if (l1 == null) {
                watcher.next = l2;
                break;
            }
            if (l2 == null) {
                watcher.next = l1;
                break;
            }
            if (l1.val <= l2.val) {
                watcher.next = l1;
                l1 = l1.next;
            } else {
                watcher.next = l2;
                l2 = l2.next;
            }
            watcher = watcher.next;

        }

        return node.next;
```


