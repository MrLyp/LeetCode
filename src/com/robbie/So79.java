package com.robbie;

public class So79 {

    public boolean exist(char[][] board, String word) {
        if (board == null || board.length == 0)
            return false;
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                visited[i][j] = true;
                if (dfs(board, word, i, j, board[i][j] + "", visited)) {
                    return true;
                }
                visited[i][j] = false;
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int i, int j, String current, boolean[][] visited) {
        if (word.equals(current))
            return true;
        if (visited[i][j])
            return false;
        String next;
        if (i + 1 < board.length && !visited[i + 1][j]) {
            next = current + board[i + 1][j];
            visited[i + 1][j] = true;
            if (word.startsWith(next) && dfs(board, word, i + 1, j, next, visited))
                return true;
            visited[i + 1][j] = false;
        }
        if (i - 1 >= 0 && !visited[i - 1][j]) {
            next = current + board[i - 1][j];
            visited[i - 1][j] = true;
            if (word.startsWith(next) && dfs(board, word, i - 1, j, next, visited))
                return true;
            visited[i - 1][j] = false;
        }
        if (j - 1 >= 0 && !visited[i][j - 1]) {
            next = current + board[i][j - 1];
            visited[i][j - 1] = true;
            if (word.startsWith(next) && dfs(board, word, i, j - 1, next, visited))
                return true;
            visited[i][j - 1] = false;
        }
        if (j + 1 < board[0].length && !visited[i][j + 1]) {
            next = current + board[i][j + 1];
            visited[i][j + 1] = true;
            if (word.startsWith(next) && dfs(board, word, i, j + 1, next, visited))
                return true;
            visited[i][j + 1] = false;
        }
        return false;
    }

    public static void main(String[] args) {
        So79 so = new So79();
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}
        };
        System.out.println(so.exist(board, "ABCCED"));
        System.out.println(so.exist(board, "SEE"));
        System.out.println(so.exist(board, "ABCB"));
        board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        System.out.println(so.exist(board, "acdb"));
    }
}
