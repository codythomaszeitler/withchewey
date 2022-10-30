package com.zsi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

public class FlattenBinaryTreeTest {

    @Test
    public void test1() {

        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(10);

        FlattenBinaryTree testObject = new FlattenBinaryTree();
        testObject.flatten(root);

        List<Integer> expected = new ArrayList<>();
        expected.add(1);
        expected.add(2);
        expected.add(3);
        expected.add(4);
        expected.add(7);
        expected.add(10);
        expected.add(5);
        expected.add(6);

        List<Integer> actual = readValues(root);
        
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldDoNothingOnNull() {
        FlattenBinaryTree testObject = new FlattenBinaryTree();

        Exception caughtException = null;
        try {
            testObject.flatten(null);
        } catch (NullPointerException e) {
            caughtException = e;
        }

        assertNull(caughtException);
    }

    @Test
    public void itShouldReturnSameNodeWhenJustOne() {
        TreeNode root = new TreeNode(3);

        FlattenBinaryTree testObject = new FlattenBinaryTree();
        testObject.flatten(root);

        List<Integer> expected = new ArrayList<>();
        expected.add(3);

        List<Integer> actual = readValues(root);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldBeAbleToFlattenWithOnlyTwo() {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);

        FlattenBinaryTree testObject = new FlattenBinaryTree();
        testObject.flatten(root);
        
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);

        List<Integer> actual = readValues(root);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldBeAbleToFlattenOnlyTwoWithOnRight() {
        TreeNode root = new TreeNode(3);
        root.right = new TreeNode(5);

        FlattenBinaryTree testObject = new FlattenBinaryTree();
        testObject.flatten(root);
        
        List<Integer> expected = new ArrayList<>();
        expected.add(3);
        expected.add(5);

        List<Integer> actual = readValues(root);
        assertEquals(expected, actual);
    }

    private List<Integer> readValues(TreeNode root) {
        List<Integer> actual = new ArrayList<>();

        TreeNode iterator = root;
        while (iterator != null) {
            actual.add(iterator.val);
            iterator = iterator.right;
        }
        return actual;
    }
}
