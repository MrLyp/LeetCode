package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So417 {

    private int[][] dir = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        List<List<Integer>> res = new ArrayList<>();
        if (matrix == null)
            return res;
        int m = matrix.length;
        if (m == 0)
            return res;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (canFlow(matrix, i, j, true, new boolean[m][n]) && canFlow(matrix, i, j, false, new boolean[m][n])) {
                    List<Integer> pointer = new ArrayList<>(2);
                    pointer.add(i);
                    pointer.add(j);
                    res.add(pointer);
                }
            }
        }
        return res;
    }

    private boolean canFlow(int[][] matrix,int i, int j, boolean p, boolean[][] visited) {
        int m = matrix.length;
        int n = matrix[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n)
            return false;
        if (p && (i == 0 || j == 0))
            return true;
        if (!p && (i == m - 1 || j == n - 1))
            return true;
        if (visited[i][j])
            return false;
        visited[i][j] = true;
        int cur = matrix[i][j];

        for (int k = 0; k < 4; k++) {
            int ni = i + dir[k][0];
            int nj = j + dir[k][1];
            boolean checkBoarder = (ni >= 0 && nj >= 0 && ni < m && nj < n);
            if (checkBoarder && cur >= matrix[ni][nj] && canFlow(matrix, ni, nj, p, visited))
                return true;
        }
        return false;
    }

    public static void main(String[] args) {
        So417 so = new So417();
        System.out.println(so.pacificAtlantic(new int[][]{
                {1, 2, 2, 3, 5},
                {3, 2, 3, 4, 4},
                {2, 4, 5, 3, 1},
                {6, 7, 1, 4, 5},
                {5, 1, 1, 2, 4}
        }));
    }
}
