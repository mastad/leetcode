[Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)

**题目**

合并K个有序链表，并保证新的链表也是有序的。

    例子：

> Input:
> [
>   1->4->5,
>   1->3->4,
>   2->6
> ]
> Output: 1->1->2->3->4->4->5->6


**思路1**

使用分治算法。其实会合并两个链表，就应该会合并 N 个。使用分治的思想不断的拆分排序再合并，就完成了。

代码：

``` java
public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 0) {
            return null;
        } else if (lists.length == 2) {
            ListNode watcher = new ListNode(0);
            ListNode node = watcher;
            ListNode l1 = lists[0];
            ListNode l2 = lists[1];
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
        } else {
            int k = lists.length / 2;
            int j = lists.length % 2;
            ListNode[] listA = new ListNode[k];
            ListNode[] listB;
            if (j > 0) {
                listB = new ListNode[k + 1];
            } else {
                listB = new ListNode[k];
            }

            for (int i = 0; i < lists.length; i++) {
                if (i < k) {
                    listA[i] = lists[i];
                } else {
                    listB[i - k] = lists[i];
                }
            }
            return mergeKLists(new ListNode[]{mergeKLists(listA), mergeKLists(listB)});
        }
    }
```

**思路2**

使用优先队列。优先队列就是专门解决这种多个数据源排序问题的，这种方式有点讨巧：使用另一种数据结构解决问题，这个是能算是对数据结构的使用，和算法关系不大。但能解决问题就好。

``` java
    public ListNode mergeKLists2(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.val));

        for (ListNode item : lists) {
            while (item != null) {
                ListNode tmp = item.next;
                item.next = null;
                queue.add(item);
                item = tmp;
            }
        }

        ListNode node = new ListNode(0);
        ListNode result = node;

        while (!queue.isEmpty()) {
            node.next = queue.poll();
            node = node.next;
        }

        return result.next;
    }
```


