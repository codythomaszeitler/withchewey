package com.zsi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class GenerateParenthesesTest {

    @Test
    public void test2() {
        String[] a = new String[] { "((()))", "(()())", "(())()", "()(())", "()()()" };

        Set<String> expected = new HashSet<>(a.length);
        for (int i = 0; i < a.length; i++) {
            expected.add(a[i]);
        }

        GenerateParentheses testObject = new GenerateParentheses();

        List<String> result = testObject.generateParenthesis(3);

        assertEquals(5, result.size());

        for (int i = 0; i < result.size(); i++) {
            assertTrue(expected.contains(result.get(i)));
        }
    }

    @Test
    public void test1() {
        String[] a = new String[] { "()" };

        Set<String> expected = new HashSet<>(a.length);
        for (int i = 0; i < a.length; i++) {
            expected.add(a[i]);
        }

        GenerateParentheses testObject = new GenerateParentheses();

        List<String> result = testObject.generateParenthesis(1);

        assertEquals(1, result.size());

        for (int i = 0; i < result.size(); i++) {
            assertTrue(expected.contains(result.get(i)));
        }
    }

    @Test
    public void test3() {
        String[] a = new String[] { "()()", "(())" };

        Set<String> expected = new HashSet<>(a.length);
        for (int i = 0; i < a.length; i++) {
            expected.add(a[i]);
        }

        GenerateParentheses testObject = new GenerateParentheses();

        List<String> result = testObject.generateParenthesis(2);

        assertEquals(2, result.size());

        for (int i = 0; i < result.size(); i++) {
            assertTrue(expected.contains(result.get(i)));
        }
    }
}
