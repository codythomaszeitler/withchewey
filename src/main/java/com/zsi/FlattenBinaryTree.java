package com.zsi;

public class FlattenBinaryTree {

    private TreeNode currentLeaf;

    public void flatten(TreeNode node) {
        if (node == null) {
            return;
        }

        preorderTraversal(node);
        TreeNode iterator = node;
        while (iterator != null) {
            if (iterator.left != null) {
                iterator.right = iterator.left;
                iterator.left = null;
            } 
            iterator = iterator.right;
        }
    }

    private void preorderTraversal(TreeNode node) {
        if (node.left == null && node.right == null) {
            currentLeaf = node;
            return;
        }

        if (node.left != null) {
            preorderTraversal(node.left);
        }

        if (node.right != null && currentLeaf != null) {
            currentLeaf.right = node.right;
            node.right = null;

            TreeNode toSearch = currentLeaf.right;
            currentLeaf = null;
            preorderTraversal(toSearch);
            return;
        } else if (node.right != null) {
            preorderTraversal(node.right);
        }
    }
}
