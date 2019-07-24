package com.robbie;

public class So200 {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0)
            return 0;
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == '1') {
                    dfs(grid, visited, i, j);
                    res++;
                }
            }
        }
        return res;
    }

    private void dfs(char[][] grid, boolean[][] visited, int i, int j) {
        if (i >= grid.length || j >= grid[0].length || i < 0 || j < 0 || visited[i][j])
            return;
        visited[i][j] = true;
        if (grid[i][j] == '0')
            return;
        dfs(grid, visited, i + 1, j);
        dfs(grid, visited, i - 1, j);
        dfs(grid, visited, i, j + 1);
        dfs(grid, visited, i, j - 1);
    }

    public static void main(String[] args) {
        So200 so = new So200();
        char[][] grid = new char[][]{"11000".toCharArray(),
                "11000".toCharArray(),
                "00100".toCharArray(),
                "00011".toCharArray()};
        System.out.println(so.numIslands(grid));
    }
}
