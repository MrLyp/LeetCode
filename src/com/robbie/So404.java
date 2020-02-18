package com.robbie;

public class So404 {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)
            return 0;
        int sum = 0;
        if (root.left != null && root.left.left == null && root.left.right == null)
            sum += root.left.val;
        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }

    public static void main(String[] args) {
        So404 so = new So404();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(so.sumOfLeftLeaves(root));
    }
}
