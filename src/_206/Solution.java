package _206;

import util.ListNode;


public class Solution {

    public ListNode reverseList(ListNode head) {
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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.reverseList(ListNode.createTestData("[3,2,0,-1]")));
    }

}