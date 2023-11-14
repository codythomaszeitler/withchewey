package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runners.model.FrameworkMethod;

public class FirstMissingPosTest {
    @Test
    public void test1() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 3, 4, -1, 1 };
        assertEquals(2, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test2() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 7, 8, 9, 11, 12 };

        assertEquals(1, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test3() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 1, 2, 0 };

        assertEquals(3, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test4() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 3, 6, 1, 2, 4, 5, 8, 9, 10, 50 };

        assertEquals(7, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test5() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { -1, -2, -2342, 3, 6, 1, 2, 4, 5, 8, 9, 10, 50 };

        assertEquals(7, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test6() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 3, 6, 1, 2, -20, 4, 5, 8, 9, 10, 50 };

        assertEquals(7, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test7() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 0, 1, 2, 3, 5 };

        assertEquals(4, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test8() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 1, 2, 3, 4 };

        assertEquals(5, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test9() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 1, 1 };

        assertEquals(2, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test10() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 0, 2, 2, 1, 1 };
        assertEquals(3, testObject.firstMissingPositive(nums));
    }

    @Test
    public void test11() {
        FirstMissingPos testObject = new FirstMissingPos();
        int[] nums = new int[] { 5, 2, 1, -1, -5, -3, -8, -5, 1, 2, 3, 4 };
        assertEquals(3, testObject.firstMissingPositive(nums));
    }
}
