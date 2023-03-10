package com.zsi;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import org.junit.Test;

public class ReverseKNodeTest {

    @Test
    public void test1() {
        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });

        ReverseKNode testObject = new ReverseKNode();
        ListNode newHead = testObject.reverseKGroup(linkedList, 3);

        ArrayList<Integer> expected = asArrayList(new int[] { 3, 2, 1, 6, 5, 4 });
        ArrayList<Integer> actual = getNumbers(newHead);
        assertEquals(expected, actual);
    }

    @Test
    public void test2() {
        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 });

        ReverseKNode testObject = new ReverseKNode();
        ListNode newHead = testObject.reverseKGroup(linkedList, 3);

        ArrayList<Integer> expected = asArrayList(new int[] { 3, 2, 1, 6, 5, 4, 7 });
        ArrayList<Integer> actual = getNumbers(newHead);
        assertEquals(expected, actual);
    }

    @Test
    public void test3() {
        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 });

        ReverseKNode testObject = new ReverseKNode();
        ListNode newHead = testObject.reverseKGroup(linkedList, 1);

        ArrayList<Integer> expected = asArrayList(new int[] { 1, 2, 3, 4, 5, 6, 7 });
        ArrayList<Integer> actual = getNumbers(newHead);
        assertEquals(expected, actual);
    }

    @Test
    public void test4() {
        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6, 7 });

        ReverseKNode testObject = new ReverseKNode();
        ListNode newHead = testObject.reverseKGroup(linkedList, 2);

        ArrayList<Integer> expected = asArrayList(new int[] { 2, 1, 4, 3, 6, 5, 7 });
        ArrayList<Integer> actual = getNumbers(newHead);
        assertEquals(expected, actual);
    }

    @Test
    public void test5() {
        ListNode linkedList = createLinkedList(new int[] { 1, 2 });

        ReverseKNode testObject = new ReverseKNode();
        ListNode newHead = testObject.reverseKGroup(linkedList, 3);

        ArrayList<Integer> expected = asArrayList(new int[] { 1, 2 });
        ArrayList<Integer> actual = getNumbers(newHead);
        assertEquals(expected, actual);
    }

    @Test
    public void test6() {
        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3 });

        ReverseKNode testObject = new ReverseKNode();
        ListNode newHead = testObject.reverseKGroup(linkedList, 3);

        ArrayList<Integer> expected = asArrayList(new int[] { 3, 2, 1 });
        ArrayList<Integer> actual = getNumbers(newHead);
        assertEquals(expected, actual);
    }

    @Test
    public void itShouldGetKthNode() {
        ReverseKNode testObject = new ReverseKNode();

        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });

        assertEquals(1, testObject.getNthNode(linkedList, 1).val);
        assertEquals(2, testObject.getNthNode(linkedList, 2).val);
        assertEquals(3, testObject.getNthNode(linkedList, 3).val);
        assertEquals(4, testObject.getNthNode(linkedList, 4).val);
        assertEquals(5, testObject.getNthNode(linkedList, 5).val);
        assertEquals(6, testObject.getNthNode(linkedList, 6).val);
    }

    @Test
    public void itShouldReturnNullIfNodeDNE() {
        ReverseKNode testObject = new ReverseKNode();
        ListNode linkedList = createLinkedList(new int[] { 1, 2, 3, 4, 5, 6 });
        assertNull(testObject.getNthNode(linkedList, 7));
    }

    private ListNode createLinkedList(int[] numbers) {
        ListNode head = new ListNode(numbers[0]);
        ListNode iter = head;
        for (int i = 1; i < numbers.length; i++) {
            ListNode current = new ListNode(numbers[i]);
            iter.next = current;
            iter = current;
        }
        return head;
    }

    private ArrayList<Integer> getNumbers(ListNode node) {
        ArrayList<Integer> numbers = new ArrayList<>();
        ListNode iterator = node;

        while (iterator != null) {
            numbers.add(iterator.val);
            iterator = iterator.next;
        }
        return numbers;
    }

    private ArrayList<Integer> asArrayList(int[] numbers) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < numbers.length; i++) {
            arrayList.add(numbers[i]);
        }
        return arrayList;
    }
}
