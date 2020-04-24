package com.robbie;

import java.util.Arrays;

public class So498 {
    public int[] findDiagonalOrder(int[][] matrix) {
        if (matrix.length == 0)
            return new int[0];
        int m = matrix.length;
        int n = matrix[0].length;
        int[] res = new int[n * m];
        int index = 0;
        int i = 0;
        int j = 0;
        boolean up = true;
        while (true) {
            if (index == n * m)
                break;
            res[index++] = matrix[i][j];
            int ni = i + (up ? -1 : 1);
            int nj = j + (up ? 1 : -1);
            if (ni < 0) {
                if (j == n - 1) {
                    i = i + 1;
                } else {
                    j = j + 1;
                }
                up = false;
                continue;
            }
            if (nj == n) {
                i ++;
                up = false;
                continue;
            }
            if (ni == m) {
                j++;
                up = true;
                continue;
            }
            if (nj < 0) {
                i++;
                up = true;
                continue;
            }
            i = ni;
            j = nj;
        }
        return res;
    }

    public static void main(String[] args) {
        So498 so = new So498();
        System.out.println(Arrays.toString(so.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5 ,6}, {7, 8, 9}, {10, 11, 12}})));
    }
}
