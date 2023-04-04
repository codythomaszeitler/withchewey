package com.zsi;

import java.util.Iterator;
import java.util.LinkedList;

public class EditDistance {
    public int minDistance(String word1, String word2) {

        LinkedList<Character> w1ll;
        LinkedList<Character> w2ll;
        if (word1.length() >= word2.length()) {
            w1ll = intoCharLinkedList(word1);
            w2ll = intoCharLinkedList(word2);
        } else {
            w1ll = intoCharLinkedList(word2);
            w2ll = intoCharLinkedList(word1);
        }

        int absoluteMin = getAbsMin(w1ll, w2ll);

        int aggregate = 0;
        while (!w1ll.isEmpty() && !w2ll.isEmpty()) {
            Character goal = w2ll.peek();

            Character terminator = null;
            if (w2ll.size() != 1) {
                terminator = w2ll.get(1);
            }

            int gap = findChar(goal, terminator, w1ll);
            if (gap != -1) {
                for (int i = 0; i < gap; i++) {
                    w1ll.pop();
                    aggregate++;
                }
            } else if (w1ll.size() >= w2ll.size()) {
                w1ll.set(0, goal);
                aggregate++;
            } else {
                w2ll.pop();
                aggregate++;
            }

            w1ll.pop();
            w2ll.pop();
        }

        if (!w1ll.isEmpty()) {
            while (!w1ll.isEmpty()) {
                w1ll.pop();
                aggregate++;
            }
        } else if (!w2ll.isEmpty()) {
            while (!w2ll.isEmpty()) {
                w2ll.pop();
                aggregate++;
            }
        }

        return Math.min(aggregate, absoluteMin);
    }

    private int getAbsMin(LinkedList<Character> longer, LinkedList<Character> shorter) {

        Iterator<Character> longerItr = longer.iterator();
        Iterator<Character> shorterItr = shorter.iterator();

        int min = 0;
        while (shorterItr.hasNext()) {
            if (shorterItr.next() != longerItr.next()) {
                min++;
            }
        }

        return min + (longer.size() - shorter.size());
    }

    private LinkedList<Character> intoCharLinkedList(String word) {
        LinkedList<Character> characters = new LinkedList<>();

        for (Character c : word.toCharArray()) {
            characters.add(c);
        }

        return characters;
    }

    private int findChar(Character goal, Character terminator, LinkedList<Character> characters) {

        int gap = 0;

        for (Character current : characters) {
            if (current == goal) {
                return gap;
            }

            if (terminator != null && current == terminator) {
                return -1;
            }

            gap++;
        }
        return -1;
    }
}
