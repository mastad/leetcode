/**
 * Created by reiserx on 2017/11/1.
 */
public class AddTwoNumbers {


    //    Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
    //    Output: 7 -> 0 -> 8
    public static void main(String[] args) {
        ListNode node11 = new ListNode(3);
        ListNode node12 = new ListNode(4);
        ListNode node13 = new ListNode(2);
        node11.next = node12;
        node12.next = node13;


        ListNode node21 = new ListNode(4);
        ListNode node22 = new ListNode(6);
        ListNode node23 = new ListNode(5);
        node21.next = node22;
        node22.next = node23;

        addTwoNumbers(node11, node21);

    }


    private static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        return null;
    }


    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
