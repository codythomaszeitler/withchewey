package com.zsi;

public class IsNumberPalindrome {
    public boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }

        int reversed = 0;


        int iter = x;
        while (iter > 0) {
            int current = iter % 10;
            reversed *= 10;
            reversed += current;

            iter = iter / 10;
        }

        return reversed == x;
    }
}
