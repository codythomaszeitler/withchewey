package com.zsi;

public class BinaryTreeMaxPathSum {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
    public class TreeNode 
    {
        int val;
        TreeNode left;
        TreeNode right;
    }

    private int current = 0;

    public int maxPathSum(TreeNode root) {
        current = root.val;
        calcMaxPathSum(root, 0);
        return current;
    }

    private int calcMaxPathSum(TreeNode node, int i)
    {
        if (node.left == null && node.right == null)
        {
            current = Math.max(current, i + node.val);
            current = Math.max(current, node.val);
            return node.val;
        }
        else if (node.right == null) 
        {
            int l = calcMaxPathSum(node.left, i + node.val);
            current = Math.max(current, l + i + node.val);
            current = Math.max(current, l + node.val);
            current = Math.max(current, node.val);

            return Math.max(node.val, l + node.val);
        }
        else if (node.left == null) 
        {
            int r = calcMaxPathSum(node.right, i + node.val);
            current = Math.max(current, r + i + node.val);
            current = Math.max(current, r + node.val);
            current = Math.max(current, node.val);

            return Math.max(node.val, r + node.val);
        }
        else 
        {
            int l = calcMaxPathSum(node.left, i + node.val);
            int r = calcMaxPathSum(node.right, i + node.val);
            
            current = Math.max(current, l + r + node.val);
            current = Math.max(current, l + i + node.val);
            current = Math.max(current, r + i + node.val);

            current = Math.max(current, l + node.val);
            current = Math.max(current, r + node.val);

            current = Math.max(current, node.val);
            current = Math.max(current, node.val + i);

            if (l < 0 && r < 0)
            {
                return node.val;
            }

            return Math.max(l + node.val, r + node.val);
        }
    }
}
