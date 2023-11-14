package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class LongestValidParensTest {

    @Test
    public void test1() {
        String s = ")()())";
        LongestValidParens testObject = new LongestValidParens();
        assertEquals(4, testObject.longestValidParentheses(s));
    }

    @Test
    public void test2() {
        String s = "(()";
        LongestValidParens testObject = new LongestValidParens();
        assertEquals(2, testObject.longestValidParentheses(s));
    }

    @Test
    public void test3() {
        String s = "";
        LongestValidParens testObject = new LongestValidParens();
        assertEquals(0, testObject.longestValidParentheses(s));
    }

    @Test
    public void test4() {
        String s = ")()(()()(";

        LongestValidParens testObject = new LongestValidParens();
        assertEquals(4, testObject.longestValidParentheses(s));
    }

    @Test
    public void test5() {
        String s = "(((((((";

        LongestValidParens testObject = new LongestValidParens();
        assertEquals(0, testObject.longestValidParentheses(s));
    }
}
