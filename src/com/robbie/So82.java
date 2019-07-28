package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/28.
 */
public class So82 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head;
        ListNode pre = new ListNode(0);
        ListNode dummy = new ListNode(0);
        dummy = pre;
        pre.next = head;
        while (cur != null) {
            ListNode next = cur.next;
            if (next == null)
                break;
            boolean flag = false;
            while(next != null && cur.val == next.val) {
                next = next.next;
                flag = true;
            }
            if (flag) {
                pre.next = next;
                cur = next;
            } else {
                pre.next = cur;
                pre = cur;
                cur = next;
            }
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        So82 so = new So82();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(2);
        ListNode l5 = new ListNode(2);
//        l1.next = l2;
//        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode.print(so.deleteDuplicates(l1));
    }
}
