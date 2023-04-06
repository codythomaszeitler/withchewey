package com.zsi;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EditDistanceTest {

    @Test
    public void testSameLengthBaseCase() {
        String a = "abc";
        String b = "abc";

        EditDistance testObject = new EditDistance();
        assertEquals(0, testObject.minDistance(a, b));
    }

    @Test
    public void testBIsLongerThanAButSamePrefix() {
        String a = "abc";
        String b = "abcde";

        EditDistance testObject = new EditDistance();
        assertEquals(2, testObject.minDistance(a, b));
    }

    @Test
    public void testAIsLongerThanBButSameSamePrefix() {
        String a = "abcde";
        String b = "abc";

        EditDistance testObject = new EditDistance();
        assertEquals(2, testObject.minDistance(a, b));
    }

    @Test
    public void testReplacingOneLetter() {
        String a = "a";
        String b = "b";

        EditDistance testObject = new EditDistance();
        assertEquals(1, testObject.minDistance(a, b));
    }

    @Test
    public void itShouldBeAbleToTurnEmptyStringIntoGoal() {

        String a = "";
        String b = "abc";

        EditDistance testObject = new EditDistance();
        assertEquals(3, testObject.minDistance(a, b));
    }

    @Test
    public void test1() {
        String a = "horse";
        String b = "ros";

        EditDistance testObject = new EditDistance();
        assertEquals(3, testObject.minDistance(a, b));
    }

    @Test
    public void test2() {
        String word1 = "intention"; String word2 = "execution";

        EditDistance testObject = new EditDistance();
        assertEquals(5, testObject.minDistance(word1, word2));
    }

    @Test
    public void test3() {
        String word1 = "prosperity";
        String word2= "properties";

        EditDistance testObject = new EditDistance();
        assertEquals(4, testObject.minDistance(word1, word2));
    }

    @Test
    public void test4() {
        String word1 = "dinitrophenylhydrazine";
        String word2 = "acetylphenylhydrazine";

        EditDistance testObject = new EditDistance();
        assertEquals(6, testObject.minDistance(word1, word2));

    }

}
