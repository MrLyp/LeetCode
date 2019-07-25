package com.robbie;

import java.util.*;

public class So133 {
    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {}

        public Node(int _val, List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashSet<Node> nodeSet = new HashSet<>();
        nodeSet.add(node);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node n = queue.poll();
            nodeSet.add(n);
            List<Node> neighbors = n.neighbors;
            for (int i = 0; i <neighbors.size(); i++) {
                if (!nodeSet.contains(neighbors.get(i)))
                    queue.add(neighbors.get(i));
            }
        }
        HashMap<Node, Node> map = new HashMap<>();
        List<Node> nodes = new ArrayList<>(nodeSet);
        for (int i = 0; i < nodes.size(); i++) {
            map.put(nodes.get(i), new Node(nodes.get(i).val, new ArrayList<Node>()));
        }
        for (int i = 0; i < nodes.size(); i++) {
            Node n = nodes.get(i);
            Node clone = map.get(n);
            for (int j = 0; j < n.neighbors.size(); j++) {
                clone.neighbors.add(map.get(n.neighbors.get(j)));
            }
        }
        return map.get(node);
    }
}
