package _021;

public class MergeTwoList {


    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }


    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l12 = new ListNode(2);
        l1.next = l12;
        ListNode l13 = new ListNode(4);
        l12.next = l13;


        ListNode l2 = new ListNode(1);
        ListNode l22 = new ListNode(3);
        l2.next = l22;
        ListNode l23 = new ListNode(4);
        l22.next = l23;


        ListNode node = mergeTwoLists(l1, l2);

        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {

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




}
