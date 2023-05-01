package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SmashRocksTest {
    @Test
    public void shouldAnswerWithTrue() {
        int[] rocks = new int[] { 2, 7, 4, 1, 8, 1 };
        SmashRocks testObject = new SmashRocks();
        assertEquals(1, testObject.lastStoneWeight(rocks) );
    }

    @Test
    public void test1() {
        int[] rocks = new int[] { 1 };
        SmashRocks testObject = new SmashRocks();
        assertEquals(1, testObject.lastStoneWeight(rocks) );
    }

    @Test
    public void test2() {
        int[] rocks = new int[] { 2,2 };
        SmashRocks testObject = new SmashRocks();
        assertEquals(0, testObject.lastStoneWeight(rocks) );
    }
}
