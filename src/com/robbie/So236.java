package com.robbie;

public class So236 {

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p, q);
    }

    private TreeNode find(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root.val == p.val || root.val == q.val) {
            return root;
        }
        TreeNode left = find(root.left, p, q);
        TreeNode right = find(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        if (left != null) {
            return left;
        }
        return right;
    }

    public static void main(String[] args) {
        So236 so = new So236();
        TreeNode root = TreeNode.stringToTreeNode("[3,5,1,6,2,0,8,null,null,7,4]");
        TreeNode res = so.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(1));
        System.out.println(res.val);
        res = so.lowestCommonAncestor(root, new TreeNode(5), new TreeNode(4));
        System.out.println(res.val);
    }
}
