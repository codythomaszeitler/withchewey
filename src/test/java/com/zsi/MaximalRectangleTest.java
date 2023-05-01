package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MaximalRectangleTest {

    @Test
    public void test1() {
        char[][] matrix = new char[3][3];
        matrix[0][0] = '1';
        matrix[0][1] = '1';
        matrix[0][2] = '1';
        matrix[1][0] = '1';
        matrix[1][1] = '1';
        matrix[1][2] = '1';
        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '1';

        MaximalRectangle testObject = new MaximalRectangle();
        assertEquals(9, testObject.maximalRectangle(matrix));
    }

    @Test
    public void test2() {
        char[][] matrix = new char[3][3];
        matrix[0][0] = '1';
        matrix[0][1] = '1';
        matrix[0][2] = '1';
        matrix[1][0] = '1';
        matrix[1][1] = '1';
        matrix[1][2] = '1';
        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '0';

        MaximalRectangle testObject = new MaximalRectangle();
        assertEquals(6, testObject.maximalRectangle(matrix));
    }

    @Test
    public void test3() {
        char[][] matrix = new char[3][3];
        matrix[0][0] = '1';
        matrix[0][1] = '1';
        matrix[0][2] = '1';
        matrix[1][0] = '1';
        matrix[1][1] = '0';
        matrix[1][2] = '1';
        matrix[2][0] = '1';
        matrix[2][1] = '1';
        matrix[2][2] = '1';

        MaximalRectangle testObject = new MaximalRectangle();
        assertEquals(3, testObject.maximalRectangle(matrix));
    }

    @Test
    public void test4() {
        char[][] matrix = new char[][] { { '1', '0', '1', '0', '0' }, { '1', '0', '1', '1', '1' },
                { '1', '1', '1', '1', '1' }, { '1', '0', '0', '1', '0' } };

        MaximalRectangle testObject = new MaximalRectangle();
        assertEquals(6, testObject.maximalRectangle(matrix));
    }

}
