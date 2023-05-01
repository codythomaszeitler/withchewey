package com.zsi;

public class MaximalRectangle {

    private int matrixWidth;
    private int matrixHeight;

    public int maximalRectangle(char[][] matrix) {

        matrixHeight = matrix.length;
        matrixWidth = matrix[0].length;

        int max = 0;
        for (int r = 0; r < matrixHeight; r++) {
            for (int c = 0; c < matrixWidth; c++) {
                max = Math.max(maxRect(r, c, matrix), max);
            }
        }
        return max;
    }

    private int maxRect(int r, int c, char[][] matrix) {
        int max = 0;
        for (int rowIndex = r; rowIndex < matrixHeight; rowIndex++) {
            for (int colIndex = c; colIndex < matrixWidth; colIndex++) {
                int w = colIndex - c + 1;
                int h = rowIndex - r + 1;
                boolean isAllOnes = isAllOnes(r, c, w, h, matrix);

                if (isAllOnes) {
                    int area = h * w;
                    max = Math.max(area, max);
                }
            }
        }
        return max;
    }

    private boolean isAllOnes(int x, int y, int w, int h, char[][] matrix) {
        for (int r = x; r < h + x; r++) {
            for (int c = y; c < w + y; c++) {
                char character = matrix[r][c];
                if (character == '0') {
                    return false;
                }
            }
        }
        return true;
    }
}
