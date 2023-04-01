package com.zsi;

public class TrappingRainWater {

    public int trap(int[] height) {
        if (height.length == 1) {
            return 0;
        }

        if (height.length == 2) {
            return 0;
        }


        int[] lefts = new int[height.length];
        int[] rights = new int[height.length];

        int lh = -1;
        for (int i = 0; i < height.length; i++) {
            lefts[i] = lh;
            int c = height[i];

            if (c >= lh) {
                lh = c;
            }
        }

        int rh = -1;
        for (int i = height.length - 1; i >= 0; i--) {
            rights[i] = rh;
            int c = height[i];

            if (c >= rh) {
                rh = c;
            }
        }

        int aggregate = 0;
        for (int i = 0; i < height.length; i++) {
            int l = lefts[i];
            int r = rights[i];

            int lower = Math.min(l, r);

            int result = lower - height[i];

            if (result >= 0) {
                aggregate += result;
            }
        }

        return aggregate;
    }
   
}
