package com.zsi;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void testSingularSquareBucket() {
        int[] heights = new int[] { 5, 0, 0, 0, 5 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(15, actual);
    }

    @Test
    public void testMoreComplexExample() {

        int[] heights = new int[] { 4, 2, 0, 3, 2, 5 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(9, actual);
    }

    @Test
    public void test1() {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(6, actual);
    }

    @Test
    public void test2() {
        int[] heights = new int[] { 0, 1 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(0, actual);
    }

    @Test
    public void test3() {
        int[] heights = new int[] { 1 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(0, actual);
    }

    @Test
    public void test4() {
        int[] heights = new int[] { 20, 0, 5 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(5, actual);
    }

    @Test
    public void test5() {
        int[] heights = new int[] { 5, 0, 20 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(5, actual);
    }

    @Test
    public void test6() {
        int[] heights = new int[] { 0, 5, 0, 20, 0 };
        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(5, actual);
    }

    @Test
    public void test7() {
        int[] heights = new int[] { 0, 5, 0, 20 };
        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(5, actual);
    }

    @Test
    public void test8() {
        int[] heights = new int[] { 5, 3, 4, 0, 6 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(8, actual);
    }

    @Test
    public void test9() {
        int[] heights = new int[] { 1000, 5, 3, 4, 0, 6 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(12, actual);
    }

    @Test
    public void test10() {
        int[] heights = new int[] { 5, 5, 1, 7, 1, 1, 5, 2, 7, 6 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(23, actual);
    }

    @Test
    public void test11() {
        int[] heights = new int[] { 5, 3, 7, 7 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(2, actual);

    }

    @Test
    public void test12() {
        int[] heights = new int[] { 3, 4, 1, 8, 1, 9, 9, 9 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(10, actual);
    }

    @Test
    public void test13() {
        int[] heights = new int[] { 1, 8, 8, 9, 1, 6, 3, 0, 0, 3, 5, 8, 0, 2, 5, 6, 5, 5, 9, 9, 6, 6, 0, 8, 9, 9, 2};

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(93, actual);
    }
}