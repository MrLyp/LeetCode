package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/28.
 */
public class So24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode p1 = head;
        ListNode p2 = head.next;
        ListNode p4 = new ListNode(0);
        ListNode newHead = p2;
        while (p1 != null) {
            p2 = p1.next;
            if (p2 == null)
                break;
            ListNode p3 = p2.next;
            p1.next = p3;
            p2.next = p1;
            p4.next = p2;
            p4 = p1;
            p1 = p3;
        }
        return newHead;
    }

    public static void main(String[] args) {
        So24 so = new So24();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode.print(so.swapPairs(l1));
    }
}
