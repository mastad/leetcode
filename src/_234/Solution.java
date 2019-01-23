package _234;

import util.ListNode;

/**
 * Author: reiserx
 * Date:2019/1/22
 * Des:回文链表
 */
public class Solution {

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

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome(ListNode.createTestData("[1,2]")));
        System.out.println(solution.isPalindrome(ListNode.createTestData("[1,2,2,1]")));
        System.out.println(solution.isPalindrome(ListNode.createTestData("[1,2,3,4]")));
    }
}
