package com.robbie;

import java.util.Arrays;

public class So289 {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0)
            return;
        int m = board.length;
        int n = board[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int live = 0;
                for (int p = -1; p <= 1; p++) {
                    for (int q = -1; q <= 1; q++) {
                        if (p == 0 && q == 0)
                            continue;
                        if (i + p >= 0 && i + p < m && j + q >= 0 && j + q < n) {
                            if (board[i + p][j + q] == 1 || board[i + p][j + q] == 3) {
                                live++;
                            }
                        }
                    }
                }
                if (board[i][j] == 0 || board[i][j] == 2) {
                    if (live == 3) {
                        board[i][j] = 2;
                    }
                } else {
                    if (live < 2 || live > 3) {
                        board[i][j] = 3;
                    }
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 2)
                    board[i][j] = 1;
                else if (board[i][j] == 3) {
                    board[i][j] = 0;
                }
            }
        }
    }

    public static void main(String[] args) {
        So289 so = new So289();
        int[][] board = new int[][]{{0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}};
        so.gameOfLife(board);
        System.out.println(Arrays.deepToString(board));
    }
}
