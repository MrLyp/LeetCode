package com.robbie;

public class So463 {
    public int islandPerimeter(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int sum = 0;
        int[][] dir = new int[][]{{-1,0}, {1,0}, {0,-1}, {0,1}};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int neighbor = 0;
                if (grid[i][j] == 1) {
                    for (int k = 0; k < 4; k++) {
                        int x = i + dir[k][0];
                        int y = j + dir[k][1];
                        if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 1)
                            neighbor++;
                    }
                    sum += 4 - neighbor;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        So463 so = new So463();
        System.out.println(so.islandPerimeter(new int[][]{{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}}));
    }
}
