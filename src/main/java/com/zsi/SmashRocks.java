package com.zsi;

import java.util.Collections;
import java.util.PriorityQueue;

public class SmashRocks {
    public int lastStoneWeight(int[] x) {
        PriorityQueue<Integer> stones = new PriorityQueue<Integer>(x.length, Collections.reverseOrder());
        for (int i = 0; i < x.length; i++) {
            stones.add(x[i]);
        }

        while (stones.size() > 1) {
            int firstStone = stones.poll();
            int secondStone = stones.poll();

            if (firstStone < secondStone) {
                int newStone = secondStone - firstStone;
                stones.add(newStone);
            } else if (firstStone > secondStone) {
                int newStone = firstStone - secondStone;
                stones.add(newStone);
            } 
        }

        if (stones.isEmpty()) {
            return 0;
        }

        return stones.poll();
    }
}
