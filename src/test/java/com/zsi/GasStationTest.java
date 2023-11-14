package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class GasStationTest {
    @Test
    public void test1() {
        int[] gas = { 5, 5, 1, 3, 4 };
        int[] cost = { 8, 1, 7, 1, 1 };


        GasStation testObject = new GasStation();
        
        int result = testObject.canCompleteCircuit(gas, cost);

        assertEquals(3, result);
    }
}
