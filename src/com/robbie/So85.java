package com.robbie;

import java.util.Arrays;

public class So85 {
    /**
     * dp[i][j]记录j列最大高度，然后计算0-j的最大宽度，得到就是最大面积
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0)
            return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == '1')
                dp[0][j] = 1;
            else
                dp[0][j] = 0;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    dp[i][j] = dp[i - 1][j] + 1;
                else
                    dp[i][j] = 0;
            }
        }
//        System.out.println(Arrays.deepToString(dp));
        int area = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int min = dp[i][j];

                for (int k = j; k >= 0; k--) {
                    min = Math.min(min, dp[i][k]);
                    area = Math.max(area, min * (j - k + 1));
                }
            }
        }
        return area;
    }

    public static void main(String[] args) {
        So85 so = new So85();
        char[][] matrix = new char[][]{{'1','0','1','0','0'},
                {'1','0','1','1','1'},
                {'1','1','1','1','1'},
                {'1','0','0','1','0'}};
        System.out.println(so.maximalRectangle(matrix));
    }
}
