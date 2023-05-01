package com.zsi;

import java.util.ArrayList;
import java.util.List;

public class GenerateParentheses {

    private int goal;

    public List<String> generateParenthesis(int n) {
        goal = n;

        ArrayList<String> result = new ArrayList<>();
        genParensHelper("", 0, 0, result);
        return result;
    }

    private void genParensHelper(String current, int numOpens, int numClosed, List<String> result) {
        if (numClosed == numOpens && goal == numOpens) {
            result.add(current);
            return;
        }

        if (numOpens < goal) {
            genParensHelper(current + "(", numOpens + 1, numClosed, result);
        }

        if (numOpens > numClosed) {
            genParensHelper(current + ')', numOpens, numClosed + 1, result);
        }
    }
}
