package com.zsi;

import static org.junit.Assert.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.junit.Test;

public class BestTimeToSellTest {

    @Test
    public void test1() {
        int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4 };

        BestTimeToSell testObject = new BestTimeToSell();
        assertEquals(6, testObject.maxProfit(prices));
    }

    @Test
    public void test2() {
        int[] prices = new int[] { 1, 2, 3, 4, 5 };

        BestTimeToSell testObject = new BestTimeToSell();
        assertEquals(4, testObject.maxProfit(prices));
    }

    @Test
    public void test3() {
        int[] prices = new int[] { 7, 6, 4, 3, 1 };

        BestTimeToSell testObject = new BestTimeToSell();
        assertEquals(0, testObject.maxProfit(prices));
    }

    @Test
    public void test4() throws IOException {
        List<String> lines = Files.readAllLines(Paths.get("/Users/codyzeitler/dev/withchewey/longarray.txt"));

        String line = lines.get(0);
        String[] numbersAsStrings = line.split(",");
        int[] numbers = new int[numbersAsStrings.length];

        for (int i = 0; i < numbersAsStrings.length; i++) {
            numbers[i] = Integer.valueOf(numbersAsStrings[i]);
        }

        BestTimeToSell testObject = new BestTimeToSell();
        assertEquals(0, testObject.maxProfit(numbers));
    }

    @Test
    public void test5() {
        int[] prices = new int[] { 3, 3, 5, 0, 0, 3, 1, 4, 0, 0, 0 };

        BestTimeToSell testObject = new BestTimeToSell();
        assertEquals(6, testObject.maxProfit(prices));
    }
}
