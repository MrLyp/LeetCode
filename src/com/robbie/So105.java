package com.robbie;

/**
 * Created by leeyunpeng on 2019/7/28.
 */
public class So105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0)
            return null;
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }

    public TreeNode build(int[] preorder, int[] inorder, int ps, int pe, int is, int ie) {
        if (ps > pe || is > ie)
            return null;
        TreeNode root = new TreeNode(preorder[ps]);
        int p = is;
        for (p = is; p < ie; p++)
            if (inorder[p] == preorder[ps])
                break;
        TreeNode left = build(preorder, inorder, ps + 1, ps + p - is, is, p - 1);
        TreeNode right = build(preorder, inorder, ps + p - is + 1 , pe, p + 1, ie);
        root.left = left;
        root.right = right;
        return root;
    }

    public static void main(String[] args) {
        So105 so = new So105();
        TreeNode root = so.buildTree(new int[]{3,9,20,15,7}, new int[]{9,3,15,20,7});
        TreeNode.print(root);
    }
}
