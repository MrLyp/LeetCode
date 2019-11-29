package com.robbie;

public class So337 {
    public int rob(TreeNode root) {
        if (root == null)
            return 0;
        return Math.max(robRoot(root), robChildren(root));
    }

    private int robRoot(TreeNode root) {
        if (root == null)
            return 0;
        int res = root.val;
        if (root.left != null) {
            res += rob(root.left.left) + rob(root.left.right);
        }
        if (root.right != null) {
            res += rob(root.right.left) + rob(root.right.right);
        }
        return res;
    }

    private int robChildren(TreeNode root) {
        if (root == null)
            return 0;
        return rob(root.left) + rob(root.right);
    }

    public static void main(String[] args) {
        So337 so = new So337();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = null;
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(1);
        System.out.println(so.rob(root));
        root = new TreeNode(3);
        root.left = new TreeNode(4);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right.left = null;
        root.right.right = new TreeNode(1);
        System.out.println(so.rob(root));
        System.out.println(so.rob(TreeNode.stringToTreeNode("4,1,null,2,null,3")));
    }
}
