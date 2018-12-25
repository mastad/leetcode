package _141;

public class LinkedListCycle {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(3);
        ListNode l2 = new ListNode(1);
        l1.next = l2;
        ListNode l3 = new ListNode(0);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;

        System.out.println(hasCycle(l1));
    }

    public static boolean hasCycle(ListNode list) {
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


}
