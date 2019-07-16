package com.robbie;

public class So23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0)
            return null;
        ListNode head = null;
        ListNode next = null;
        while (true) {
            ListNode node = findSmallestHead(lists);
            if (node == null)
                break;
            if (head == null) {
                head = new ListNode(node.val);
                next = head;
            } else {
                next.next = new ListNode(node.val);
                next = next.next;
            }

        }
        return head;
    }

    private ListNode findSmallestHead(ListNode[] lists) {
        int index = 0;
        int min = Integer.MAX_VALUE;
        ListNode node = null;
        for (int i = 0; i < lists.length; i++) {
            if (lists[i] == null)
                continue;
            ListNode cur = lists[i];
            if (min > cur.val) {
                min = cur.val;
                index = i;
                node = new ListNode(min);
                node.next = cur.next;
            }
        }
        if (node != null) {
            lists[index] = node.next;
            return node;
        }
        return null;
    }

    public static void main(String[] args) {
        So23 so = new So23();
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);
        ListNode res = so.mergeKLists(new ListNode[]{l1, l2,  l3});
        ListNode p = res;
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}
