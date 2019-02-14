package com.robbie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class So207 {

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>(numCourses);
        // 构建图
        boolean[] visited = new boolean[numCourses];
        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> nodes = graph.get(prerequisites[i][1]);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], nodes);
        }


        for (int i = 0; i < numCourses; i++) {
            if (!dfs(graph, i, visited))
                return false;
        }
        return true;
    }

    private boolean dfs(Map<Integer, ArrayList<Integer>> graph, int index, boolean[] visited) {
        if (visited[index])
            return false;
        visited[index] = true;
        ArrayList<Integer> nodes = graph.get(index);
        if (nodes == null) {
            visited[index] = false;
            return true;
        }
        for (int i = 0; i < nodes.size(); i++) {
            if (!dfs(graph, nodes.get(i), visited))
                return false;
        }
        visited[index] = false;
        return true;
    }

    public static void main(String[] args) {
        So207 so = new So207();
        check(so.canFinish(2, new int[][]{{1, 0}}), true);
        check(so.canFinish(2, new int[][]{{1, 0}, {0, 1}}), false);
    }

    private static void check(boolean result, boolean expect) {
        if (result == expect) {
            System.out.println("pass");
        } else {
            throw new RuntimeException("expect " + expect);
        }
    }
}
