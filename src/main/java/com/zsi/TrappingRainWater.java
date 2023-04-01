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

        int index = 0;
        while (index < initial.size() - 1) {
            AggregateResult result = findNextHighestConvex(initial, height, index);

            aggregate += result.aggregate;
            index = result.endingIndex;
        }

        return aggregate;
    }

    public static AggregateResult findNextHighestConvex(List<Convex> convexes, int[] heights,
            int startIndex) {
        int starting = heights[convexes.get(startIndex).index];

        int aggregate = 0;
        for (int i = startIndex, j = startIndex + 1; j < convexes.size(); i++, j++) {
            Convex left = convexes.get(i);
            Convex right = convexes.get(j);

            aggregate += calculate(left, right, heights);

            int current = heights[right.index];

            if (starting <= current) {
                AggregateResult result = new AggregateResult();
                result.aggregate = calculate(convexes.get(startIndex), right, heights);
                result.endingIndex = j;
                return result;
            }
        }

        AggregateResult result = new AggregateResult();
        result.aggregate = aggregate;
        result.endingIndex = convexes.size() - 1;
        return result;
    }

    public static class AggregateResult {
        public int aggregate;
        public int endingIndex;
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
