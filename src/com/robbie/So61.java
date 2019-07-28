package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/28.
 */
public class So61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return null;
        int n = 0;
        ListNode p = head;
        ListNode tail = head;
        while (p != null) {
            p = p.next;
            n++;
            if (p != null)
                tail = p;
        }
        k = k % n;
        p = head;
        int i = n - k;
        tail.next = head;
        while (--i > 0) {
            p = p.next;
        }
        ListNode newHead = p.next;
        p.next = null;
//        tail.next = head;
        return newHead;
    }

    public static void main(String[] args) {
        So61 so = new So61();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode.print(so.rotateRight(l1, 4));
    }
}
