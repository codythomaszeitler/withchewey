package com.zsi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AverageSalaryTest {

    @Test
    public void shouldAnswerWithTrue() {
        int[] salary = new int[] { 1000, 2000, 3000 };
        AverageSalary testObject = new AverageSalary();
        assertEquals(2000, testObject.average(salary), 0);
    }

    @Test
    public void test2() {
        int[] salary = new int[] { 4000, 3000, 1000, 2000 };
        AverageSalary testObject = new AverageSalary();

        assertEquals(2500, testObject.average(salary), 0);
    }

    @Test
    public void test3() {
        int[] salary = new int[] { 48000, 59000, 99000, 13000, 78000, 45000, 31000, 17000, 39000, 37000, 93000, 77000,
                33000, 28000, 4000, 54000, 67000, 6000, 1000, 11000 };

        AverageSalary testObject = new AverageSalary();
        assertEquals(41111.11111, testObject.average(salary), 0);
    }
}
