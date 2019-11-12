package com.robbie;

/**
 * facebook 面试考题
 */
public class So211 {

    class TrieNode {
        TrieNode[] children;
        boolean isLeaf;

        TrieNode() {
            children = new TrieNode[26];
        }
    }

    class Trie {
        TrieNode root;

        Trie() {
            root = new TrieNode();
        }

        public void add(String s) {
            TrieNode curr = root;
            for (char ch : s.toCharArray()) {
                if (curr.children[ch - 'a'] == null) curr.children[ch - 'a'] = new TrieNode();
                curr = curr.children[ch - 'a'];
            }
            curr.isLeaf = true;
        }

        public boolean search(String s, TrieNode curr, int idx) {
            if (idx == s.length()) return curr.isLeaf;
            char ch = s.charAt(idx);
            if (ch != '.') {
                if (curr.children[ch - 'a'] == null) return false;
                return search(s, curr.children[ch - 'a'], idx + 1);
            } else {
                for (char c = 'a'; c <= 'z'; c++) {
                    if (curr.children[c - 'a'] != null) {
                        if (search(s, curr.children[c - 'a'], idx + 1)) return true;
                    }
                }
            }
            return false;
        }
    }

    class WordDictionary {

        Trie trie;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            trie = new Trie();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            trie.add(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return trie.search(word, trie.root, 0);
        }
    }
}
