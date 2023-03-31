package com.zsi;

import static org.junit.Assert.assertEquals;

import java.util.List;

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
    public void testFindFirstNonIncreasingNumberIndex() {
        int[] heights = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

        TrappingRainWater.Convex convex = TrappingRainWater.findNextConvex(heights, 0);
        assertEquals(convex, new TrappingRainWater.Convex(1));
    }

    @Test
    public void testFindConvexesOnHill() {
        int[] heights = new int[] { 3, 5, 5, 5, 5, 5, 2 };
        List<TrappingRainWater.Convex> convexes = TrappingRainWater.getConvexes(heights);

        assertEquals(2, convexes.size());
    }
}
