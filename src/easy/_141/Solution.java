package easy._141;

import util.ListNode;

public class Solution {
    
    public  boolean hasCycle(ListNode list) {
        if (list == null) return false;

        ListNode fast = list.next;
        ListNode slow = list;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (slow == fast) return true;
        }

        return false;
    }


    public static void main(String[] args) {
        Solution  solution=new Solution();
        System.out.println(solution.hasCycle(ListNode.createTestData("[3,1,0,4]")));
    }


}
