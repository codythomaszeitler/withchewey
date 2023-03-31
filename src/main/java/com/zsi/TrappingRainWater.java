package com.zsi;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

    public int trap(int[] height) {
        List<Convex> initial = getConvexes(height);

        int[] peaks = new int[initial.size()];
        for (int i = 0; i < initial.size(); i++) {
            int index = initial.get(i).index;
            peaks[i] = height[index];
        }

        List<Convex> completed = getConvexes(peaks);

        List<Convex> toComputeWith = new ArrayList<>();
        if (!completed.contains(initial.get(0))) {
            toComputeWith.add(initial.get(0));
        }

        for (Convex a : completed) {
            Convex b = initial.get(a.index);
            toComputeWith.add(b);
        }

        if (!completed.contains(initial.get(initial.size() - 1))) {
            toComputeWith.add(initial.get(initial.size() - 1));
        }

        int capturedWater = 0;

        for (int i = 0; i < toComputeWith.size() - 1; i++) {
            Convex left = toComputeWith.get(i);
            Convex right = toComputeWith.get(i + 1);

            capturedWater += calculate(left, right, height);
        }

        return capturedWater;
    }

    public static int calculate(Convex left, Convex right, int[] heights) {
        int lower = Math.min(heights[left.index], heights[right.index]);
        int box = (right.index - left.index - 1) * lower;

        for (int i = left.index + 1; i < right.index; i++) {
            box -= heights[i];
        }

        return box;
    }

    public static List<Convex> getConvexes(int[] heights) {
        ArrayList<Convex> convexes = new ArrayList<>();

        if (heights.length == 1) {
            convexes.add(new Convex(0));
            return convexes;
        }

        if (heights.length == 2) {
            convexes.add(new Convex(0));
            convexes.add(new Convex(1));
            return convexes;
        }

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

                if (left < middle) {
                    maybeConvex = new Convex(i);
                }

                if (left < middle && middle > right) {
                    convexes.add(new Convex(i));
                    maybeConvex = null;
                } else if (left == middle && middle > right) {
                    if (maybeConvex != null) {
                        convexes.add(maybeConvex);
                        convexes.add(new Convex(i));
                    }
                }
            }
        }

        return convexes;
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
