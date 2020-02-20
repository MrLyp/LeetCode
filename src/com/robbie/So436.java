package com.robbie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class So436 {
    public int[] findRightInterval(int[][] intervals) {
        int[][] arr = intervals.clone();
        Arrays.sort(arr, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        Map<Integer, Integer> map = new HashMap<>(intervals.length);
        for (int i = 0; i < intervals.length; i++)
            map.put(intervals[i][0], i);
        int[] res = new int[intervals.length];
        for (int i = 0; i < arr.length; i++) {
            int end = arr[i][1];
            int j;
            // binary search to speed up
            for (j = i + 1; j < arr.length; j++) {
                if (arr[j][0] >= end) {
                    res[map.get(arr[i][0])] = map.get(arr[j][0]);
                    break;
                }
            }
            if (j >= arr.length)
                res[map.get(arr[i][0])] = -1;
        }
        return res;
    }

    public static void main(String[] args) {
        So436 so = new So436();
        System.out.println(Arrays.toString(so.findRightInterval(new int[][]{{1, 4}, {2, 3}, {3, 4}})));
    }
}
