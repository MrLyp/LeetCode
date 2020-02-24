package com.robbie;

public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }

    public static ListNode create(int[] arr) {
        ListNode node = new ListNode(0);
        ListNode head = node;
        for (int i = 0; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            head.next = next;
            head = next;
        }
        return node.next;
    }

    public static void print(ListNode node) {
        ListNode p = node;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
