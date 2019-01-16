[Remove Nth Node From End of List](https://leetcode.com/problems/remove-nth-node-from-end-of-list/)

**题目**

移除链表中倒数第 N 个结点

例子:

> input 1->2->3->4->5, and n = 2.
> output 1->2->3->5.


**思路1**

使用 List 来让链表支持随机访问的特性，这样问题就变得简单了。但我始终觉得，使用其他数据结构来解决问题，是一种“作弊”

代码:

``` java
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> tmp = new ArrayList<>();
        while (head != null) {
            tmp.add(head);
            head = head.next;
        }
        if (tmp.size() == 1) {
            return null;
        }
        if (n == tmp.size()) {
            return tmp.get(1);
        }
        int index = tmp.size() - n;
        ListNode removeNode = tmp.get(index);
        ListNode preNode = tmp.get(index - 1);
        preNode.next = removeNode.next;
        return tmp.get(0);
    }
```

**思路2**

使用双指针，单向链表的问题很多时候都是用双指针解决，就是跑步的思维。初始化两个指针 `p1` `p2`,要实现找到倒数第 `k` 个元素。让 `p1` 先跑 `k-1` 个位置，`p2` 再跑。当 `p1` 跑到链表尾部时，`p2` 所在的位置就是要删除的元素。注意代码的鲁棒性

代码：

``` java
   public ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n == 0) {
            return null;
        }
        ListNode del = head;
        ListNode end = head;
        for (int i = 0; i < n - 1; ++i) {
            if (end.next != null) {
                end = end.next;
            } else {
                return null;
            }
        }
        ListNode tmp = del;
        while (end.next != null) {
            end = end.next;
            tmp = del;
            del = del.next;
        }
        if (del == head) {
            head = head.next;
        } else {
            tmp.next = del.next;
        }
        return head;
    }
```

