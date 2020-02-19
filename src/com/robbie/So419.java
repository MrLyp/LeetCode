package com.robbie;

public class So419 {
    public int countBattleships(char[][] board) {
        if (board == null || board.length == 0)
            return 0;
        int sum = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == 'X') {
                    sum++;
                    if ((i > 0 && board[i - 1][j] == 'X') || (j > 0 && board[i][j - 1] == 'X'))
                        sum--;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        So419 so = new So419();
        System.out.println(so.countBattleships(new char[][]{
                {'X', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
                {'.', '.', '.', 'X'},
        }));
    }
}
