package com.robbie;

import java.util.Arrays;

public class So221 {

    public int maximalSquare(char[][] matrix) {
        int m = matrix.length;
        if (m == 0)
            return 0;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = 1;
                else
                    dp[i][j] = 0;
                max = Math.max(max, dp[i][j]);
            }
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                char current = matrix[i][j];
                int left = dp[i][j-1];
                int top = dp[i-1][j];
                int corner = dp[i-1][j-1];
                dp[i][j] = Character.getNumericValue(matrix[i][j]);
                if(current == '1' && left != 0 && top != 0 && corner !=0) {
                    dp[i][j] = Math.min(Math.min(left,top), corner) + 1;
                }
                max = Math.max(max, dp[i][j]);
            }
        }

//        for (int i = 0; i < m; i++) {
//            System.out.println(Arrays.toString(dp[i]));
//        }
        return max * max;
    }

    public static void main(String[] args) {
        So221 so = new So221();
        char[][] matrix = new char[][]{{'1', '0', '1', '0', '0'}, {'1', '0', '1', '1', '1'}, {'1', '1', '1', '1', '1'}, {'1', '0', '1', '1', '1'}};
        int res = so.maximalSquare(matrix);
        System.out.println(res);
        matrix = new char[][]{{'1'}};
        System.out.println(so.maximalSquare(matrix));
    }


}
