package com.robbie;

import java.util.HashMap;
import java.util.Map;

public class So454 {
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        int n = A.length;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sum = A[i] + B[j];
                int count = map1.getOrDefault(sum, 0);
                map1.put(sum, count + 1);
                sum = C[i] + D[j];
                count = map2.getOrDefault(sum, 0);
                map2.put(sum, count + 1);
            }
        }
        int sum = 0;
        for (Integer i : map1.keySet()) {
            if (map2.containsKey(-i)) {
                sum += map1.get(i) * map2.get(-i);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        So454 so = new So454();
        System.out.println(so.fourSumCount(new int[]{1,2}, new int[]{-2,-1}, new int[]{2, -1}, new int[]{0,2}));
    }
}
