package com.robbie;

public class So19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode p = head;
        ListNode q = head;
        for (int i = 0; i < n; i++) {
            if (q != null) q = q.next;
        }
        while (q != null && q.next != null) {
            p = p.next;
            q = q.next;
        }
        if (p != null && p.next != null)
            p.next = p.next.next;
        return head;
    }

    public static void main(String[] args) {
        So19 so = new So19();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode.print(so.removeNthFromEnd(l1, 2));
    }
}
