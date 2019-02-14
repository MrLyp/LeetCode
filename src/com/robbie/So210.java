package com.robbie;

import java.util.*;

public class So210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        Map<Integer, ArrayList<Integer>> graph = new HashMap<>(numCourses);
        int[] degree = new int[numCourses];
        // 构建图
        for (int i = 0; i < prerequisites.length; i++) {
            ArrayList<Integer> nodes = graph.get(prerequisites[i][1]);
            if (nodes == null) {
                nodes = new ArrayList<>();
            }
            nodes.add(prerequisites[i][0]);
            graph.put(prerequisites[i][1], nodes);
            // 计算节点入度
            degree[prerequisites[i][0]]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        int[] result = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (degree[i] == 0) {
                queue.offer(i);
            }
        }
        int index = 0;
        while (queue.size() > 0) {
            int node = queue.poll();
            result[index++] = node;
            if (index > numCourses)
                return new int[0];
            ArrayList<Integer> children = graph.get(node);
            if (children == null)
                continue;
            for (int child : children) {
                degree[child]--;
                if (degree[child] == 0)
                    queue.offer(child);
            }
        }
        if (index != numCourses)
            return new int[0];
        return result;
    }

    public static void main(String[] args) {
        So210 so = new So210();
        check(so.findOrder(2, new int[][]{{1, 0}}), new int[]{0, 1});
        check(so.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {3, 2}}), new int[]{0, 1, 2, 3});
        check(so.findOrder(4, new int[][]{{1, 0}, {2, 0}, {3, 1}, {0, 3}}), new int[0]);
    }

    private static void check(int[] result, int[] expected) {
        System.out.println(Arrays.toString(result));
        for (int i = 0; i < result.length; i++) {
            if (result[i] != expected[i]) {
                throw new RuntimeException();
            }
        }
    }
}
