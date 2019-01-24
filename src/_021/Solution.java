package _021;

import util.ListNode;

public class Solution {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.mergeTwoLists(ListNode.createTestData("[1,2,4]"), ListNode.createTestData("[1,3,4]")));
    }


}
