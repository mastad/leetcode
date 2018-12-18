package list;

public class ReverseLinkedList {
    public static void main(String[] args) {
//        ListNode n1 = new ListNode(1);
//        ListNode n2 = new ListNode(2);
//        n1.next = n2;
//        ListNode n3 = new ListNode(3);
//        n2.next = n3;
//        ListNode n4 = new ListNode(4);
//        n3.next = n4;
//        ListNode n5 = new ListNode(5);
//        n4.next = n5;
//        printAll(reverseList(n1));


        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(0);
        n2.next = n3;
        ListNode n4 = new ListNode(-4);
        n3.next = n4;
        n4.next = n2;

    }


    public static ListNode reverseList(ListNode head) {
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

    //跑步思想，set判断重复
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




    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void printAll(ListNode list) {
        ListNode p = list;
        while (p != null) {
            System.out.print(p.val + "-->");
            p = p.next;
        }
        System.out.println();
    }

}