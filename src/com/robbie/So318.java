package com.robbie;

public class So318 {
    class Node {
        private String word;
        private int mask;

        public Node(String word) {
            this.word = word;
            for (int i = 0; i < word.length(); i++) {
                mask |= (1 << (word.charAt(i) - 'a'));
            }
        }

        public boolean hasCommon(Node node) {
            return (this.mask & node.mask) != 0;
        }
    }

    public int maxProduct(String[] words) {
        Node[] nodes = new Node[words.length];
        for (int i = 0; i < words.length; i++) {
            nodes[i] = new Node(words[i]);
        }
        int max = 0;
        for (int i = 0; i < nodes.length; i++) {
            for (int j = 0; j < nodes.length;j++) {
                if (i == j || nodes[i].hasCommon(nodes[j]))
                    continue;
                max = Math.max(max, nodes[i].word.length() * nodes[j].word.length());
            }
        }

        return max;
    }

    public static void main(String[] args) {
        So318 so = new So318();
        System.out.println(so.maxProduct(new String[]{"abcw","baz","foo","bar","xtfn","abcdef"}));
        System.out.println(so.maxProduct(new String[]{"a","ab","abc","d","cd","bcd","abcd"}));
    }

}
