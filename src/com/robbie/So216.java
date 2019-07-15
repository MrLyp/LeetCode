package com.robbie;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class So216 {

    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] visited = new boolean[10];
        dfs(result, new ArrayList<Integer>(), visited, k, n);
        return result;
    }

    private void dfs(List<List<Integer>> result, List<Integer> res, boolean[] visited, int k, int n) {
        if (k < 0 || n < 0) {
            return;
        }
        if (k == 0 && n == 0) {
            List<Integer> clone = new ArrayList<>(res);
            Collections.sort(clone);
            if (!result.contains(clone))
                result.add(clone);
        }
        for (int i = 1; i <= 9; i++) {
            if (n - i < 0)
                break;
            if (!visited[i]) {
                visited[i] = true;
                Integer integer = i;
                res.add(integer);
                dfs(result, res, visited, k - 1, n - i);
                res.remove(integer);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        So216 so = new So216();
        List<List<Integer>> res = so.combinationSum3(3, 7);
        System.out.println(res);
        res = so.combinationSum3(3, 9);
        System.out.println(res);
    }
}
