package com.zsi;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {
    
    public boolean isValidSudoku(char[][] board) {
    
        ArrayList<SudokuSolution> leftToRight = new ArrayList<SudokuSolution>(9);
        ArrayList<SudokuSolution> upToDown = new ArrayList<SudokuSolution>(9);
        ArrayList<ArrayList<SudokuSolution>> squares = new ArrayList<ArrayList<SudokuSolution>>(9);
        
        for (int i = 0; i < 9; i++) {
            leftToRight.add(i, new SudokuSolution());
            upToDown.add(i, new SudokuSolution());
        }
        
        for (int i = 0; i < 3; i ++) {
            ArrayList<SudokuSolution> square = new ArrayList<SudokuSolution>(9);
            for (int j = 0; j < 3; j++) {
                square.add(j, new SudokuSolution());
            }
            squares.add(i, square);
        }
        
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char piece = board[i][j];
                if (piece != '.') {
                    leftToRight.get(i).add(piece);
                    upToDown.get(j).add(piece);

                    squares.get(i / 3).get(j / 3).add(piece);
                }
            }
        }
        
        for (int i = 0; i < 9; i++) {
            if (!leftToRight.get(i).isCurrentlyOkay()) {
                return false;        
            }
            for (int j = 0; j < 9; j++) {
                if (!upToDown.get(j).isCurrentlyOkay()) {
                    return false;
                }
                
                if (!squares.get(i / 3).get(j / 3).isCurrentlyOkay()) {
                    return false;
                }
            }
        }
        
        return true;
    }
    
    private static class SudokuSolution {
        
        private Set<Character> numbers = new HashSet<Character>();
        private Integer count = 0;
        
        public void add(char piece) {
            this.numbers.add(piece);
            count = count + 1;
        }
        
        public Boolean isCurrentlyOkay() {
            return this.numbers.size() == this.count;
        }
    }
}