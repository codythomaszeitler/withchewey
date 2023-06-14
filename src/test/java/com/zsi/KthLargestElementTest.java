package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthLargestElementTest {
    // Input: nums = [3,2,1,5,6,4], k = 2
    // Output: 5

    @Test
    public void test1() {
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        KthLargestElement testObject = new KthLargestElement();

        int kthLargest = testObject.findKthLargest(nums, 2);
        assertEquals(5, kthLargest);
    }

    @Test
    public void test2() {
        // Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
        // Output: 4
        int[] nums = new int[] { 3, 2, 1, 5, 6, 4 };
        KthLargestElement testObject = new KthLargestElement();

        int kthLargest = testObject.findKthLargest(nums, 2);
        assertEquals(5, kthLargest);
    }
}
