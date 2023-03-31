package com.zsi;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

    public static List<Convex> getConvexes(int[] heights) {
        ArrayList<Convex> convexes = new ArrayList<>();

        // Convex convex = findNextConvex(heights, 0);
        // convexes.add(convex);
        // do {
        // convex = findNextConvex(heights, convex.index + 1);
        // if (convex != null) {
        // convexes.add(convex);
        // }
        // } while (convex != null);

        Convex maybeConvex = null;
        for (int i = 0; i < heights.length; i++) {

            int middle = heights[i];
            if (i == 0) {
                int right = heights[i + 1];
                if (middle > right) {
                    convexes.add(new Convex(i));
                }
            } else if (i == heights.length - 1) {
                int left = heights[i - 1];
                if (left < middle) {
                    convexes.add(new Convex(i));
                }
            } else {
                int left = heights[i - 1];
                int right = heights[i + 1];

                if (left < middle && middle > right) {
                    convexes.add(new Convex(i));
                } else if (left < middle && middle == right && maybeConvex == null) {
                    maybeConvex = new Convex(i);
                } else if (left < middle && middle == right && maybeConvex != null) {
                    maybeConvex = new Convex(i);
                } else if (left == middle && middle > right && maybeConvex != null) {
                    convexes.add(maybeConvex);
                    convexes.add(new Convex(i));
                } else if (left == middle && middle > right && maybeConvex == null) {
                    convexes.add(new Convex(i));
                }
            }
        }

        return convexes;
    }

    // So this really is not correct.
    public static Convex findNextConvex(int[] heights, int previousIndex) {

        for (int i = previousIndex + 1; i < heights.length; i++) {
            if (heights[previousIndex] <= heights[i]) {
                break;
            }
            previousIndex = i;
        }

        for (int i = previousIndex + 1; i < heights.length; i++) {
            if (heights[previousIndex] > heights[i]) {
                return new Convex(previousIndex);
            }
            previousIndex = i;
        }

        return null;
    }

    public static class Convex {
        public int index;

        public Convex(int index) {
            this.index = index;
        }

        public boolean equals(Object o) {
            if (o == null) {
                return false;
            }

            if (!(o instanceof Convex)) {
                return false;
            }

            Convex casted = (Convex) o;
            return this.index == casted.index;
        }
    }
}
