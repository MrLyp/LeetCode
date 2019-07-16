package com.robbie;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static void print(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
