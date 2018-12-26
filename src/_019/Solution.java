package _019;

import util.ListNode;

import java.util.ArrayList;
import java.util.List;


public class Solution {

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

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData("[1,2,3,4,5]"), 2));
        ListNode.print(solution.removeNthFromEnd(ListNode.createTestData("[1]"), 1));

    }


}
