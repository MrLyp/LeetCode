package com.robbie;

public class So304 {
    static class NumMatrix {

        private int[][] sum;

        public NumMatrix(int[][] matrix) {
            int n = matrix.length;
            if (n == 0)
                return;
            int m = matrix[0].length;
            sum = new int[n][m];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    int rsum = matrix[i][j];
                    if (j > 0)
                        rsum += sum[i][j - 1];
                    if (i > 0)
                        rsum += sum[i - 1][j];
                    if (i > 0 && j > 0)
                        rsum -= sum[i - 1][j - 1];
                    sum[i][j] = rsum;
                }
            }
        }

        public int sumRegion(int row1, int col1, int row2, int col2) {
            if (sum == null)
                return 0;
            int result = sum[row2][col2];
            if (row1 > 0)
                result -= sum[row1 - 1][col2];
            if (col1 > 0)
                result -= sum[row2][col1 - 1];
            if (row1 > 0 && col1 > 0)
                result += sum[row1 - 1][col1 - 1];
            return result;
        }
    }

    public static void main(String[] args) {
        int[][] array = new int[][]{{3, 0, 1, 4, 2},
                {5, 6, 3, 2, 1},
                {1, 2, 0, 1, 5},
                {4, 1, 0, 1, 7},
                {1, 0, 3, 0, 5}};
        NumMatrix matrix = new NumMatrix(array);
        System.out.println(matrix.sumRegion(2, 1, 4, 3));
        System.out.println(matrix.sumRegion(1, 1, 2, 2));
        System.out.println(matrix.sumRegion(1, 2, 2, 4));
    }
}
