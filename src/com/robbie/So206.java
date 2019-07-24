package com.robbie;

public class So206 {
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return null;
        ListNode t1 = head;
        ListNode t2 = t1.next;
        ListNode temp;
        while (true) {
            if (t1.next == null || t2 == null)
                break;
            temp = t2.next;
            t2.next = t1;
            if (t1 == head)
                t1.next = null;
            t1 = t2;
            t2 = temp;
        }
        return t1;
    }

    public static void main(String[] args) {
        So206 so = new So206();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode.print(so.reverseList(l1));
    }
}
