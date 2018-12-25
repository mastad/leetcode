package _206;

//206
public class ReverseLinkedList {
    public static void main(String[] args) {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        ListNode n3 = new ListNode(0);
        n2.next = n3;
        ListNode n4 = new ListNode(-4);
        n3.next = n4;
        n4.next = n2;

        ListNode p = reverseList(n1);
        while (p != null) {
            System.out.print(p.val + "-->");
            p = p.next;
        }
        System.out.println();

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


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}