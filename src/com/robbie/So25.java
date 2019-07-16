package com.robbie;

public class So25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return null;
        int len = k;
        ListNode p = head;
        while (p != null && len-- > 0) {
            p = p.next;
        }
        if (len > 0)
            return head;
        ListNode node = reverse(head, k);
        tailOf(node, k).next = reverseKGroup(p, k);
        return node;
    }

    private ListNode tailOf(ListNode node, int k) {
        ListNode temp = node;
        while (k-- > 0 && temp != null && temp.next != null)
            temp = temp.next;
        return temp;
    }

    private ListNode reverse(ListNode node, int k) {
        ListNode t1 = node;
        ListNode t2 = t1.next;
        ListNode temp;
        while (--k > 0) {
            if (t1.next == null)
                break;
            temp = t2.next;
            t2.next = t1;
            if (t1 == node)
                t1.next = null;
            t1 = t2;
            t2 = temp;
        }
        return t1;
    }

    public static void main(String[] args) {
        So25 so = new So25();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode res = so.reverseKGroup(l1, 1);
        ListNode.print(res);
    }
}
