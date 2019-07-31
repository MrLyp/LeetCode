package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/28.
 */
public class So86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null)
            return null;
        ListNode smallHead = new ListNode(0);
        ListNode small = smallHead;
        ListNode bigHead = new ListNode(0);
        ListNode big = bigHead;
        ListNode p = head;
        while(p != null) {
            if (p.val < x) {
                small.next = p;
                small = p;
            } else {
                big.next = p;
                big = p;
            }
            p = p.next;
        }
        big.next = null;
        small.next = bigHead.next;
        return smallHead.next;
    }

    public static void main(String[] args) {
        So86 so = new So86();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(4);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(2);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode.print(so.partition(l1, 3));
    }
}
