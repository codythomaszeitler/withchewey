package com.zsi;

import java.util.Stack;

public class LongestValidParens {
    public int longestValidParentheses(String s) {
        int[] longest = new int[s.length()];

        for (int i = 0; i < s.length(); i++) {
            longest[i] = -1;
        }

        int currentMax = 0;

        Stack<ParenWithIndex> parens = new Stack<ParenWithIndex>();
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {

                if (longest[j] != -1) {
                    currentMax = Math.max(longest[i], currentMax);
                    break;
                }

                Character paren = s.charAt(j);
                if (paren == '(') {
                    parens.push(new ParenWithIndex('(', j));
                } else if ((paren == ')' && parens.isEmpty()) || (parens.peek().paren == ')')) {
                    i = j;
                    break;
                } else if (parens.peek().paren == '(') {
                    parens.pop();

                    if (parens.isEmpty()) {
                        currentMax = Math.max(currentMax, (j - i + 1));
                        longest[i] = currentMax;
                    } else {
                        int currentStackTopIndex = parens.peek().index;
                        longest[currentStackTopIndex + 1] = (j - currentStackTopIndex);
                    }
                }
            }
            while (!parens.isEmpty()) {
                ParenWithIndex parenWithIndex = parens.pop();
                longest[parenWithIndex.index] = 0;
            }
        }
        return currentMax;
    }

    private class ParenWithIndex {
        private final Character paren;
        private final int index;

        private ParenWithIndex(Character paren, int index) {
            this.paren = paren;
            this.index = index;
        }
    }
}
