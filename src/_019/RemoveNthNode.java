package _019;

import java.util.ArrayList;
import java.util.List;

//19
public class RemoveNthNode {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
//        l1.next = l2;
        ListNode l3 = new ListNode(3);
        l2.next = l3;
        ListNode l4 = new ListNode(4);
        l3.next = l4;
        ListNode l5 = new ListNode(5);
        l4.next = l5;


        ListNode node = removeNthFromEnd(l1, 1);


        while (node != null) {
            System.out.print(node.val + "-->");
            node = node.next;
        }
        System.out.println();

    }


    public static ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> tmp = new ArrayList<>();

        while (head != null) {
            tmp.add(head);
            head = head.next;
        }
        if(tmp.size()==1){
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

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
