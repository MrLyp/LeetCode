package com.robbie;

import java.util.Arrays;

public class So329 {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return 0;
        int n = matrix.length;
        int m = matrix[0].length;
        int[][] dp = new int[n][m];
        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                int res = search(matrix, dp, i, j);
                max = Math.max(max, res);
            }
        }
        return max;
    }

    private int search(int[][] matrix, int[][] dp, int i, int j) {
        int n = matrix.length;
        int m = matrix[0].length;
        if (i >= n || j >= m || i < 0 || j < 0)
            return 0;
        if (dp[i][j] > 0)
            return dp[i][j];
        int left = 0;
        if (i - 1 >= 0 && matrix[i - 1][j] > matrix[i][j])
            left = 1 + search(matrix, dp, i - 1, j);
        int right = 0;
        if (i + 1 < n && matrix[i + 1][j] > matrix[i][j])
            right = 1 + search(matrix, dp, i + 1, j);
        int top = 0;
        if (j - 1 >= 0 && matrix[i][j - 1] > matrix[i][j])
            top = 1 + search(matrix, dp, i, j - 1);
        int bottom = 0;
        if (j + 1 < m && matrix[i][j + 1] > matrix[i][j])
            bottom = 1 + search(matrix, dp, i, j + 1);
        int max = findMax(left, right, top, bottom, 1);
        dp[i][j] = max;
        return max;
    }

    private int findMax(int... array) {
        int max = 0;
        for (int item : array)
            max = Math.max(max, item);
        return max;
    }

    public static void main(String[] args) {
        So329 so = new So329();
        int[][] matrix = new int[][]{{9, 9, 4},
                {6, 6, 8},
                {2, 1, 1}};
        System.out.println(so.longestIncreasingPath(matrix));
        matrix = new int[][]{
                {3, 4, 5},
                {3, 2, 6},
                {2, 2, 1}
        };
        System.out.println(so.longestIncreasingPath(matrix));
    }

}
