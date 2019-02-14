package com.robbie;

public class So208 {
    static class TrieNode {
        public char val;
        public TrieNode[] children;
        public boolean isWord;

        public TrieNode() {
            this('。');
        }

        public TrieNode(char c) {
            this.val = c;
            this.children = new TrieNode[26];
        }

        public boolean isLeaf() {
            for (int i = 0; i < children.length; i++) {
                if (children[i] != null)
                    return false;
            }
            return true;
        }
    }

    static class Trie {

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
                    node.children[index] = new TrieNode(c);
                }
                node = node.children[index];
            }
            node.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = this.root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null)
                    return false;
                node = node.children[index];
            }
            return node.isWord;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = this.root;
            for (int i = 0; i < prefix.length(); i++) {
                char c = prefix.charAt(i);
                int index = c - 'a';
                if (node.children[index] == null)
                    return false;
                node = node.children[index];
            }
            return true;
        }
    }


    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        boolean result = trie.search("apple");   // returns true
        System.out.println(result);
        result = trie.search("app");     // returns false
        System.out.println(result);
        result = trie.startsWith("app"); // returns true
        System.out.println(result);
        trie.insert("app");
        result = trie.search("app");     // returns true
        System.out.println(result);
    }
}
