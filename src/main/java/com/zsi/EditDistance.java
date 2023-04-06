package com.zsi;

import java.util.HashMap;
import java.util.Map;

public class EditDistance {

    private Map<String, Integer> saved;

    public EditDistance() {
        this.saved = new HashMap<>();
    }

    public int minDistance(String word1, String word2) {
        if (this.saved.containsKey(word1)) {
            return this.saved.get(word1);
        }

        if (word1.equals(word2)) {
            this.saved.put(word1, 0);
            return 0;
        }

        if (word2.startsWith(word1)) {
            int minDistance = word2.length() - word1.length();
            this.saved.put(word1, minDistance);
            return minDistance;
        }

        if (word1.startsWith(word2)) {
            int minDistance = word1.length() - word2.length();
            this.saved.put(word1, minDistance);
            return minDistance;
        }

        int length = Math.min(word1.length(), word2.length());
        int minDistance = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (word1.charAt(i) != word2.charAt(i)) {
                String deleted = delete(word1, i);
                minDistance = Math.min(minDistance(deleted, word2) + 1, minDistance);

                String replaced = replace(word1, word2.charAt(i), i);
                minDistance = Math.min(minDistance(replaced, word2) + 1, minDistance);

                String inserted = insert(word1, word2.charAt(i), i);
                minDistance = Math.min(minDistance(inserted, word2) + 1, minDistance);

                break;
            }
        }

        this.saved.put(word1, minDistance);

        return minDistance;
    }

    private String delete(String word, int i) {
        StringBuilder builder = new StringBuilder(word);
        builder.deleteCharAt(i);

        return builder.toString();
    }

    private String replace(String word, char character, int i) {
        StringBuilder builder = new StringBuilder(word);
        builder.setCharAt(i, character);
        return builder.toString();
    }

    private String insert(String word, char character, int i) {
        StringBuilder builder = new StringBuilder(word);
        builder.insert(i, character);
        return builder.toString();
    }

}
