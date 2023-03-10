package com.zsi;

import java.util.ArrayList;

public class BestTimeToSell {

    private int[][] cache;
    // private boolean runCache;        

    public int maxProfit(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int startOfZeros = prices.length; 
        initCache(startOfZeros);
        findMaxRun(0, startOfZeros, prices);

        int currentMax = 0;
        for (int i = 0; i < startOfZeros; i++) {
            // 0 to i
            int left = findMaxRun(0, i + 1, prices);
            int right = findMaxRun(i + 1, startOfZeros, prices);

            int computed = left + right;
            if (currentMax < computed) {
                currentMax = computed;
            }
        }

        return currentMax;
    }

    private void initCache(int length) {
        cache = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j < length; j++) {
                cache[i][j] = -1;
            }
        }
    }

    private int findMaxRun(int l, int r, int[] prices) {
        if (l == r) {
            return 0;
        }
        if (isInCache(l, r - 1)) {
            return cache[l][r - 1];
        }

        int currentMax = 0;
        for (int i = l; i < r; i++) {
            int left = prices[i];

            int currentInnerLoopMax = 0;
            for (int j = i + 1; j < r; j++) {
                int right = prices[j];
                int computed = right - left;

                if (currentInnerLoopMax < computed) {
                    currentInnerLoopMax = computed;
                }
            }

            if (currentMax < currentInnerLoopMax) {
                currentMax = currentInnerLoopMax;
            }

            if (i != l) {
                putInCache(i, r - 1, currentInnerLoopMax);
            }
        }

        putInCache(l, r - 1, currentMax);
        return currentMax;
    }

    private Boolean isInCache(int l, int r) {
        // if (!runCache) {
        //     return false;
        // }

        return cache[l][r] != -1;
    }

    private void putInCache(int l, int r, int value) {
        // if (runCache) {
            cache[l][r] = value;
        // }
    }

    private int findStartOfEndingZeros(int[] prices) {
        for (int i = prices.length - 1; i >= 0; i--) {
            if (prices[i] != 0) {
                return i + 1;
            }
        }
        return 0;
    }
}
