package com.robbie;

import java.util.Stack;

public class So445 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();
        ListNode h1 = l1;
        while (h1 != null) {
            stack1.push(h1.val);
            h1 = h1.next;
        }
        ListNode h2 = l2;
        while (h2 != null) {
            stack2.push(h2.val);
            h2 = h2.next;
        }
        int c = 0;
        ListNode head = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || c != 0) {
            int sum = 0;
            sum += stack1.isEmpty() ? 0 : stack1.pop();
            sum += stack2.isEmpty() ? 0 : stack2.pop();
            sum += c;
            ListNode pre = head;
            head = new ListNode(sum % 10);
            head.next = pre;
            c = sum / 10;
        }
        if (head == null)
            return new ListNode(0);
        else
            return head;
    }

    public static void main(String[] args) {
        So445 so = new So445();
        ListNode res = so.addTwoNumbers(ListNode.create(new int[]{7,2,4,3}), ListNode.create(new int[]{5,6,4}));
        ListNode.print(res);
    }
}
