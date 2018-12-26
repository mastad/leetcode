package _876;

import util.ListNode;

public class Solution {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.middleNode(ListNode.createTestData("[1,2,3,4,5,6]")));
        ListNode.print(solution.middleNode(ListNode.createTestData("[1,2,3,4,5,6,7]")));
        ListNode.print(solution.middleNode(ListNode.createTestData("[1]")));

    }


}
