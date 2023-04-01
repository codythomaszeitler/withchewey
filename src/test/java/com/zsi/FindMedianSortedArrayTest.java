package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.zsi.FindMedianSortedArray.IntArraySlice;

public class FindMedianSortedArrayTest {

    @Test
    public void test1() {
        int[] nums1 = new int[] { 1, 3, 5, 7, 9 };
        int[] nums2 = new int[] { 2, 4, 6, 8, 10 };

        FindMedianSortedArray testObject = new FindMedianSortedArray();
        double result = testObject.findMedianSortedArrays(nums1, nums2);
        assertEquals(5.5, result, 0.00001);
    }

    @Test
    public void test2() {
        int[] nums1 = new int[] { 1, 3, 5, 6, 7 };
        int[] nums2 = new int[] { 2, 4 };

        FindMedianSortedArray testObject = new FindMedianSortedArray();
        double result = testObject.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result, 0.0001);
    }

     @Test
    public void test22() {
        int[] nums1 = new int[] { 2, 4 };
        int[] nums2 = new int[] { 1, 3, 5, 6, 7 };

        FindMedianSortedArray testObject = new FindMedianSortedArray();
        double result = testObject.findMedianSortedArrays(nums1, nums2);
        assertEquals(4, result, 0.0001);
    }

    @Test
    public void test3() {
        int[] nums1 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        int[] nums2 = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };

        FindMedianSortedArray testObject = new FindMedianSortedArray();
        double result = testObject.findMedianSortedArrays(nums1, nums2);
        assertEquals(5, result, 0.0001);
    }

    @Test
    public void test4() {
        int[] nums1 = new int[] { 1, 2, 3, 4, 5, 6, 7 };
        int[] nums2 = new int[] { 0, 1, 2, 3 };

        FindMedianSortedArray testObject = new FindMedianSortedArray();
        double result = testObject.findMedianSortedArrays(nums1, nums2);
        assertEquals(5, result, 0.0001);
    }

    @Test
    public void testFindNumLeftElements() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
        int goal = 6;

        IntArraySlice a = new IntArraySlice(nums);

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToLeft(goal, a);
        assertEquals(4, numElementsToLeft);
    }

    @Test
    public void testFindNumLeftElementsBiggerThanNothing() {
        int[] nums = new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int goal = 6;

        IntArraySlice a = new IntArraySlice(nums);

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToLeft(goal, a);
        assertEquals(-1, numElementsToLeft);
    }

    @Test
    public void testFindNumLeftElementsBiggerThanNothingASlice() {
        int[] nums = new int[] { 0, 1, 2, 3, 10, 11, 12, 13, 14, 15 };
        int goal = 6;

        IntArraySlice a = new IntArraySlice(nums);
        a.l = 4;

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToLeft(goal, a);
        assertEquals(3, numElementsToLeft);
    }

    @Test
    public void testFindNumLeftElementsBiggerThanEverything() {
        int[] nums = new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int goal = 20;

        IntArraySlice a = new IntArraySlice(nums);

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToLeft(goal, a);
        assertEquals(9, numElementsToLeft);
    }

    @Test
    public void testFindNumRightElements() {
        int[] nums = new int[] { 1, 2, 3, 4, 5, 7, 8, 9, 10 };
        int goal = 6;

        IntArraySlice a = new IntArraySlice(nums);

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToRight(goal, a);
        assertEquals(5, numElementsToLeft);
    }

    @Test
    public void testFindNumRightElementsBiggerThanEverything() {
        int[] nums = new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int goal = 20;

        IntArraySlice a = new IntArraySlice(nums);

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToRight(goal, a);
        assertEquals(9, numElementsToLeft);
    }

    @Test
    public void testFindNumRightElementsBiggerThanNothing() {
        int[] nums = new int[] { 7, 8, 9, 10, 11, 12, 13, 14, 15 };
        int goal = 6;

        IntArraySlice a = new IntArraySlice(nums);

        int numElementsToLeft = FindMedianSortedArray.getNumElementsToLeft(goal, a);
        assertEquals(-1, numElementsToLeft);
    }
}
