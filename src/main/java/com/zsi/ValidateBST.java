package com.zsi;

import java.util.ArrayList;
import java.util.List;

public class ValidateBST {

    private List<Integer> numbers = new ArrayList<>();

    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return false;
        }

        inorderTraversal(root);
        return isSorted();
    }

    private void inorderTraversal(TreeNode node) {
        if (node == null) {
            return;
        }

        inorderTraversal(node.left);
        numbers.add(node.val);
        inorderTraversal(node.right);
    }

    private Boolean isSorted() {
        for (int i = 0; i < numbers.size() - 1; i++) {
            int left = numbers.get(i);
            int right = numbers.get(i + 1);

            if (right <= left) {
                return false;
            }
        }
        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
