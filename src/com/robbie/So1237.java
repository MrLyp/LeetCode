package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So1237 {
    static class CustomFunction {
        // Returns f(x, y) for any given positive integers x and y.
        // Note that f(x, y) is increasing with respect to both x and y.
        // i.e. f(x, y) < f(x + 1, y), f(x, y) < f(x, y + 1)
        public int f(int x, int y) {
            return x * y;
        }
    }

    public List<List<Integer>> findSolution(CustomFunction customfunction, int z) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= z; i++) {
            for (int j = 1; j <= z; j++) {
                List<Integer> pair = new ArrayList<>(2);
                if (customfunction.f(i, j) == z) {
                    pair.add(i);
                    pair.add(j);
                    result.add(pair);
                    continue;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        So1237 so = new So1237();
        System.out.println(so.findSolution(new CustomFunction(), 5));
    }
}
