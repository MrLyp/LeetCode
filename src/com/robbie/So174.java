package com.robbie;

import java.util.Arrays;

// https://leetcode.com/problems/dungeon-game/
public class So174 {

    public int calculateMinimumHP(int[][] dungeon) {
        int m = dungeon.length;
        int n = dungeon[0].length;
        int[][] h = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            h[i][n] = Integer.MAX_VALUE;
        }
        h[m-1][n] = 1;
        for (int i = 0; i <= n; i++) {
            h[m][i] = Integer.MAX_VALUE;
        }
        h[m][n-1] = 1;
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int blood = Math.min(h[i + 1][j], h[i][j + 1]) - dungeon[i][j];
                if (blood > 0) {
                    h[i][j] = blood;
                } else {
                    h[i][j] = 1;
                }
            }
        }

        return h[0][0];
    }

    public static void main(String[] args) {
        int[][] dungeon = new int[][]{{-2, -3, 3}, {-5, -10, 1}, {10, 30, -5}};
        So174 so = new So174();
        System.out.println(so.calculateMinimumHP(dungeon));
        System.out.println(so.calculateMinimumHP(new int[][]{{0,0}}));
    }
}
