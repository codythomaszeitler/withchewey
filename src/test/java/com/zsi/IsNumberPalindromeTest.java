package com.zsi;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class IsNumberPalindromeTest {
    @Test
    public void shouldAnswerWithTrue() {
        int number = 121;

        IsNumberPalindrome testObject = new IsNumberPalindrome();
        assertTrue(testObject.isPalindrome(number));
    }

    @Test
    public void test2() {
        int number = 10;
        IsNumberPalindrome testObject = new IsNumberPalindrome();
        assertFalse(testObject.isPalindrome(number));
    }
}
