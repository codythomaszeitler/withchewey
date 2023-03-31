package com.zsi;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

import org.junit.Test;

public class TrappingRainWaterTest {

    @Test
    public void testGetConvexes() {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);
        assertEquals(4, convexes.size());

        assertEquals(convexes.get(0), new TrappingRainWater.Convex(1));
        assertEquals(convexes.get(1), new TrappingRainWater.Convex(3));
        assertEquals(convexes.get(2), new TrappingRainWater.Convex(7));
        assertEquals(convexes.get(3), new TrappingRainWater.Convex(10));
    }

    @Test
    public void testFindConvexesOnHill() {
        int[] heights = new int[] { 3, 5, 5, 5, 5, 5, 2 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(2, convexes.size());
    }

    @Test
    public void testFindConvexesWithSingularHillPoint() {
        int[] heights = new int[] { 0, 2, 2, 10, 2, 2, 0 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(1, convexes.size());

        assertEquals(convexes.get(0), new TrappingRainWater.Convex(3));
    }

    @Test
    public void testSmallSpeedBumps() {
        int[] heights = new int[] { 1, 0, 1, 0, 1, 0, 1 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(4, convexes.size());
    }

    @Test
    public void testSmallSpeedBumpsNoEnding() {
        int[] heights = new int[] { 1, 0, 1, 0, 1, 0 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(3, convexes.size());
    }

    @Test
    public void testSmallSpeedBumpsBigGap() {
        int[] heights = new int[] { 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(4, convexes.size());
    }

    @Test
    public void testSuperSmallConvexCall() {
        int[] heights = new int[] { 5, 5 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(2, convexes.size());
    }

    @Test
    public void testSingularSquareBucket() {
        int[] heights = new int[] { 5, 0, 0, 0, 5 };

        TrappingRainWater solution = new TrappingRainWater();
        int actual = solution.trap(heights);

        assertEquals(15, actual);
    }

    @Test
    public void testSimpleCalculate() {
        int[] heights = new int[] { 5, 0, 0, 0, 5 };

        int actual = TrappingRainWater.calculate(new TrappingRainWater.Convex(0), new TrappingRainWater.Convex(4),
                heights);

        assertEquals(15, actual);
    }

    @Test
    public void testSimpleCalculateWithBumpyUnderneath() {
        int[] heights = new int[] { 5, 2, 0, 3, 5 };

        int actual = TrappingRainWater.calculate(new TrappingRainWater.Convex(0), new TrappingRainWater.Convex(4),
                heights);

        assertEquals(10, actual);
    }

    @Test
    public void testSimpleCalculateAllFilled() {
        int[] heights = new int[] { 5, 5, 5, 5, 5 };

        int actual = TrappingRainWater.calculate(new TrappingRainWater.Convex(0), new TrappingRainWater.Convex(4),
                heights);

        assertEquals(0, actual);
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
}