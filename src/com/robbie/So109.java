package com.robbie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeyunpeng on 2019/7/28.
 */
public class So109 {
    public TreeNode sortedListToBST(ListNode head) {
        ListNode p = head;
        List<Integer> list = new ArrayList<>();
        while (p != null) {
            list.add(p.val);
            p = p.next;
        }
        return build(list, 0, list.size() - 1);
    }

    private TreeNode build(List<Integer> list, int left, int right) {
        if (left > right)
            return null;
        int mid = (right - left) / 2 + left;
        TreeNode root = new TreeNode(list.get(mid));
        TreeNode leftNode = build(list, left, mid - 1);
        TreeNode rightNode = build(list, mid + 1, right);
        root.left = leftNode;
        root.right = rightNode;
        return root;
    }

    public static void main(String[] args) {
        So109 so = new So109();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        TreeNode root = so.sortedListToBST(l1);
        TreeNode.print(root);
    }
}
