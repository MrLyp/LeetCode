package com.robbie;

import java.util.*;

public class So399 {

    /**
     * 刚开始的时候想偷懒直接用除法计算，但是对于图里不相邻的节点是无法通过除法计算出来的
     * @param equations
     * @param values
     * @param queries
     * @return
     */
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            double value = values[i];
            String numerator = equations.get(i).get(0);
            String denominator = equations.get(i).get(1);
            if (!graph.containsKey(numerator)) {
                graph.put(numerator, new HashMap<>());
            }
            if (!graph.containsKey(denominator)) {
                graph.put(denominator, new HashMap<>());
            }

            graph.get(numerator).put(denominator, value);
            graph.get(denominator).put(numerator, 1 / value);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String numerator = queries.get(i).get(0);
            String denominator = queries.get(i).get(1);
            if (!graph.containsKey(numerator) || !graph.containsKey(denominator)) {
                res[i] = -1.0;
                continue;
            }
            if (numerator.equals(denominator)) {
                res[i] = 1.0;
            } else {
                res[i] = dfs(graph, new HashSet<>(), numerator, denominator, 1.0);
            }
        }
        return res;
    }

    private double dfs(Map<String, Map<String, Double>> graph, HashSet<String> visited, String from, String to, double res) {
        if (from.equals(to)) {
            return res;
        }
        Map<String, Double> nodes = graph.get(from);
        visited.add(from);
        for (String node: nodes.keySet())  {
            if (!visited.contains(node)) {
                double value = dfs(graph, visited, node, to, res * nodes.get(node));
                if (value >= 0)
                    return value;
            }
        }
        return -1.0;
    }

    public static void main(String[] args) {
        So399 so = new So399();
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a", "b"));
        list.add(Arrays.asList("b", "c"));
        List<List<String>> query = new ArrayList<>();
        query.add(Arrays.asList("a", "c"));
        query.add(Arrays.asList("b", "a"));
        query.add(Arrays.asList("a", "e"));
        query.add(Arrays.asList("a", "a"));
        query.add(Arrays.asList("x", "x"));
        System.out.println(Arrays.toString(so.calcEquation(list, new double[]{2.0, 3.0}, query)));
    }
}
