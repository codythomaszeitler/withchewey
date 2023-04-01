package com.zsi;

import java.util.ArrayList;
import java.util.List;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }

        if (height.length == 2) {
            return 0;
        }

        List<Convex> initial = getConvexes(height);

        int aggregate = 0;

        int i = 0;
        while (i < initial.size() - 1) {
            int nhi = findNextHighestIndex(initial, height, i);

            Convex left = initial.get(i);
            Convex right = initial.get(nhi);

            aggregate += calculate(left, right, height);

            i = nhi;
        }

        return aggregate;
    }

    public static int findNextHighestIndex(List<Convex> convexes, int[] heights, int si) {
        int s = heights[convexes.get(si).index];

        int h = -1;
        int hi = -1;

        for (int i = si + 1; i < convexes.size(); i++) {
            Convex convex = convexes.get(i);
            int c = heights[convex.index];

            if (c >= h) {
                h = c;
                hi = i;
            }

            if (c >= s) {
                return i;
            }
        }

        return hi;
    }

    public static int calculate(Convex left, Convex right, int[] heights) {
        int lower = Math.min(heights[left.index], heights[right.index]);
        int box = (right.index - left.index - 1) * lower;

        for (int i = left.index + 1; i < right.index; i++) {
            box -= Math.min(lower, heights[i]);
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
                        maybeConvex = null;
                    }
                }
            }
        }

        if (!convexes.contains(new Convex(0))) {
            convexes.add(0, new Convex(0));
        }

        if (!convexes.contains(new Convex(heights.length - 1)) ){
            convexes.add(new Convex(heights.length - 1));
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

        public String toString() {
            return this.index + "";
        }
    }
}
