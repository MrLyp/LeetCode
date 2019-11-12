package com.robbie;

import java.util.*;

public class So212 {
     class TrieNode {
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
            this.children = new TrieNode[26];
        }
    }

     class Trie {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            this.root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
            }
            node.isWord = true;
        }
    }

    public List<String> findWords(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        int m = board.length;
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> res = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, visited, i, j, trie.root, "", res);
            }
        }
        return new ArrayList<>(res);
    }

    private void dfs(char[][] board, boolean[][] visited, int i, int j, TrieNode node, String path, Set<String> res) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[i].length || visited[i][j] || node == null) {
            return;
        }

        char c = board[i][j];
        TrieNode child = node.children[c - 'a'];
        if (child == null) {
            return;
        }
        if (child.isWord) {
            res.add(path + c);
        }
        visited[i][j] = true;
        int m = board.length;
        int n = board[i].length;
        for (int p = -1; p <= 1; p++) {
            for (int q = -1; q <= 1; q++) {
                if (p * q != 0)
                    continue;
                int ni = i + p;
                int nj = j + q;
                if (ni < 0 || ni >= m || nj < 0 || nj >= n || visited[ni][nj])
                    continue;
                dfs(board, visited, ni, nj, child, path + c, res);
            }
        }
        visited[i][j] = false;
    }

    public static void main(String[] args) {
        So212 so = new So212();
        char[][] board = new char[][]{{'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}};
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(so.findWords(board, words));
        board = new char[][]{{'a', 'b'}, {'c', 'd'}};
        words = new String[]{"abcd"};
        System.out.println(so.findWords(board, words));
    }
}
