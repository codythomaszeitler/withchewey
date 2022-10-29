package com.zsi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.zsi.ValidateBST.TreeNode;

public class ValidateBSTTest {

    @Test
    public void test1() {
        TreeNode rootNode = new TreeNode(2);
        TreeNode left = new TreeNode(1);
        TreeNode right = new TreeNode(3);

        rootNode.left = left;
        rootNode.right = right;

        ValidateBST testObject = new ValidateBST();
        assertTrue(testObject.isValidBST(rootNode));
    }

    @Test
    public void test2() {
        TreeNode rootNode = new TreeNode(7);

        rootNode.left = new TreeNode(3);
        rootNode.right = new TreeNode(10);

        rootNode.left.left = new TreeNode(2);
        rootNode.left.right = new TreeNode(4);

        rootNode.right.right = new TreeNode(11);
        rootNode.right.left = new TreeNode(9);

        rootNode.right.right.right = new TreeNode(15);
        rootNode.right.right.right.right = new TreeNode(16);
        rootNode.right.right.right.left = new TreeNode(14);

        ValidateBST testObject = new ValidateBST();
        assertTrue(testObject.isValidBST(rootNode));
    }

    @Test
    public void test3() {
        TreeNode rootNode = new TreeNode(7);

        rootNode.left = new TreeNode(4);
        rootNode.right = new TreeNode(10);

        rootNode.left.left = new TreeNode(2);
        rootNode.left.right = new TreeNode(3);

        rootNode.right.right = new TreeNode(11);
        rootNode.right.left = new TreeNode(9);

        rootNode.right.right.right = new TreeNode(15);
        rootNode.right.right.right.right = new TreeNode(16);
        rootNode.right.right.right.left = new TreeNode(14);

        ValidateBST testObject = new ValidateBST();
        assertFalse(testObject.isValidBST(rootNode));
    }

    @Test
    public void test4() {
        TreeNode rootNode = new TreeNode(4);

        ValidateBST testObject = new ValidateBST();
        assertTrue(testObject.isValidBST(rootNode));
    }

    @Test
    public void test5() {
        ValidateBST testObject = new ValidateBST();
        assertFalse(testObject.isValidBST(null));
    }

    @Test
    public void test6() {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);

        ValidateBST testObject = new ValidateBST();
        assertFalse(testObject.isValidBST(root));
    }
}
