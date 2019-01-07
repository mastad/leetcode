package _023;

import util.ListNode;

public class Solution {

    //除了分治算法，优先队列貌似也能解决该问题
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        } else if (lists.length == 0) {
            return null;
        } else if(lists.length==2){
            ListNode watcher = new ListNode(0);
            ListNode node = watcher;
            ListNode l1=lists[0];
            ListNode l2=lists[1];
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
        }else {
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

    //使用优先队列

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.mergeKLists(new ListNode[]{ListNode.createTestData("[1,4,5]"), ListNode.createTestData("[1,3,4]"), ListNode.createTestData("[2,6]")}));
    }


}
