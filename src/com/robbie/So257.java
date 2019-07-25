package com.robbie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class So257 {
    public List<String> binaryTreePaths(TreeNode root) {
        Set<String> res = new HashSet<>();
        if (root == null)
            return new ArrayList<>();
        dfs(res, "", root);
        return new ArrayList<>(res);
    }

    private void dfs(Set<String> res, String path, TreeNode root) {
        if (root.left == null && root.right == null) {
            res.add(makePath(path, root));
            return;
        }
        path = makePath(path, root);
        if (root.left != null)
            dfs(res, path, root.left);
        if (root.right != null)
            dfs(res, path, root.right);
    }

    private String makePath(String path, TreeNode node) {
        if (path.length() > 0)
            path = path + "->";
        return path + node.val;
    }

    public static void main(String[] args) {
        So257 so = new So257();
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(4);
        root.right.left = new TreeNode(3);
        root.right.right = new TreeNode(6);
        System.out.println(so.binaryTreePaths(root));
    }
}
