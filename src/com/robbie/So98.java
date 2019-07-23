package com.robbie;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by leeyunpeng on 2019/7/23.
 */
public class So98 {
    public boolean isValidBST(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inorder(res, root);
        for (int i = 1; i < res.size(); i++) {
            if (res.get(i - 1) >= res.get(i))
                return false;
        }
        return true;
    }

    private void inorder(List<Integer> res, TreeNode root) {
        if (root == null)
            return;
        if (root.left != null)
            inorder(res, root.left);
        res.add(root.val);
        if (root.right != null)
            inorder(res, root.right);
    }

    public static void main(String[] args) {
        So98 so = new So98();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(so.isValidBST(root));
    }
}
