package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CandyTest {

    @Test
    public void test1() 
    {
        int[] ratings = {1,3,2,2,1};

        Candy testObject = new Candy();

        int min = testObject.candy(ratings);
        assertEquals(7, min);
    }

    @Test
    public void test2() {
        int[] ratings = {1, 0, 2};

        Candy testObject = new Candy();

        int min = testObject.candy(ratings);
        assertEquals(5, min);
    }
}
