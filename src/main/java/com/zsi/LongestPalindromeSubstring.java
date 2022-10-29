package com.zsi;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class LongestPalindromeSubstring {

    public String longestPalindrome(String input) {

        if (isPalindrome(input)) {
            return input;
        }

        String currentLongest = "";

        Map<Character, Locations> characterToLocations = new HashMap<>();
        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            if (!characterToLocations.containsKey(current)) {
                characterToLocations.put(current, new Locations());
            }
            characterToLocations.get(current).push(i);
        }

        for (int i = 0; i < input.length(); i++) {
            char current = input.charAt(i);
            Locations locations = characterToLocations.get(current);

            for (Integer position : locations.locations) {
                if (i > position + 1) {
                    break;
                }

                String substring = input.substring(i, position + 1);
                Boolean isPalindrome = isPalindrome(substring);

                if (isPalindrome && currentLongest.length() < substring.length()) {
                    currentLongest = substring;
                    break; 
                }
            }
        }
        
        return currentLongest;
    }

    public Boolean isPalindrome(String toCheck) {
        for (int i = 0; i < toCheck.length() / 2; i++) {

            char atStart = toCheck.charAt(i);
            char atEnd = toCheck.charAt(toCheck.length() - 1 - i);

            if (atStart != atEnd) {
                return false;
            }
        }
        return true;
    }

    private static class Locations {
        private LinkedList<Integer> locations;

        public Locations() {
            this.locations = new LinkedList<>();
        }

        public void push(Integer loc) {
            this.locations.addFirst(loc);
        }
    }
}
