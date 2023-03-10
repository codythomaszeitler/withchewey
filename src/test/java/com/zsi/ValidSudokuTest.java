package com.zsi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class ValidSudokuTest {

    @Test
    public void test1() {
        char[][] board = new char[][] { { '5', '3', '.', '.', '7', '.', '.', '.', '.' },
                { '6', '.', '.', '1', '9', '5', '.', '.', '.' }, { '.', '9', '8', '.', '.', '.', '.', '6', '.' },
                { '8', '.', '.', '.', '6', '.', '.', '.', '3' }, { '4', '.', '.', '8', '.', '3', '.', '.', '1' },
                { '7', '.', '.', '.', '2', '.', '.', '.', '6' }, { '.', '6', '.', '.', '.', '.', '2', '8', '.' },
                { '.', '.', '.', '4', '1', '9', '.', '.', '5' }, { '.', '.', '.', '.', '8', '.', '.', '7', '9' } };

        ValidSudoku testObject = new ValidSudoku();
        assertTrue(testObject.isValidSudoku(board));
    }

    @Test
    public void test2() {
        char[][] board = new char[][] { 
                { '.', '.', '.', '.', '5', '.', '.', '1', '.' },
                { '.', '4', '.', '3', '.', '.', '.', '.', '.' }, 
                { '.', '.', '.', '.', '.', '3', '.', '.', '1' },
                { '8', '.', '.', '.', '.', '.', '.', '2', '.' }, 
                { '.', '.', '2', '.', '7', '.', '.', '.', '.' },
                { '.', '1', '5', '.', '.', '.', '.', '.', '.' }, 
                { '.', '.', '.', '.', '.', '2', '.', '.', '.' },
                { '.', '2', '.', '9', '.', '.', '.', '.', '.' }, 
                { '.', '.', '4', '.', '.', '.', '.', '.', '.' } };

        ValidSudoku testObject = new ValidSudoku();
        assertFalse(testObject.isValidSudoku(board));
    }
}
