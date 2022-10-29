package com.zsi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LongestPalindromeSubstringTest {
    @Test
    public void test1() {
        String testString = "abcderacecaryxzwv";
        String expected = "racecar";

        LongestPalindromeSubstring solution = new LongestPalindromeSubstring();

        String actual = solution.longestPalindrome(testString);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        String testString = "cbbd";
        String expected = "bb";

        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        String actual = testObject.longestPalindrome(testString);

        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        String testString = "aacabdkacaa";
        String expected = "aca";

        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        String actual = testObject.longestPalindrome(testString);

        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        String testString = "1111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111111";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        String actual = testObject.longestPalindrome(testString);
        assertEquals(testString, actual);
    }

    @Test
    public void itShouldReturnTrueOnPalindromeOddLength() {
        String testString = "racecar";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        assertTrue(testObject.isPalindrome(testString));
    }

    @Test
    public void itShouldReturnTrueOnPalindromeEvenLength() {
        String testString = "aabbbbaa";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        assertTrue(testObject.isPalindrome(testString));
    }

    @Test
    public void itShouldReturnFalseOnNonPalindrome() {
        String testString = "notapalindrome";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        assertFalse(testObject.isPalindrome(testString));
    }

    @Test
    public void itShouldReturnTrueOnOneLetter() {
        String testString = "a";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        assertTrue(testObject.isPalindrome(testString));
    }

    @Test
    public void itShouldReturnTrueWithTwoCharsSame() {
        String testString = "aa";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        assertTrue(testObject.isPalindrome(testString));
    }

    @Test
    public void itShouldReturnTrueWithTwoCharsDifferent() {
        String testString = "ab";
        LongestPalindromeSubstring testObject = new LongestPalindromeSubstring();
        assertFalse(testObject.isPalindrome(testString));
    }
}
