package _002;

import util.ListNode;

public class Solution {

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.addTwoNumbers(ListNode.createTestData("[2,4,3]"), ListNode.createTestData("[5,6,4]")));
        ListNode.print(solution.addTwoNumbers(ListNode.createTestData("[5]"), ListNode.createTestData("[5]")));
        ListNode.print(solution.addTwoNumbers(ListNode.createTestData("[1,8]"), ListNode.createTestData("[0]")));
        ListNode.print(solution.addTwoNumbers(ListNode.createTestData("[1,8]"), ListNode.createTestData("[9]")));
    }
}
