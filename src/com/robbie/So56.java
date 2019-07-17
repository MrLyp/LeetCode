package com.robbie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class So56 {
    public int[][] merge(int[][] intervals) {
        if (intervals == null)
            return null;
        if (intervals.length == 0)
            return intervals;
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int[] cur = intervals[0];
        List<int[]> res = new ArrayList<>();
        for (int i = 1; i < intervals.length; i++) {
            int[] iter = intervals[i];
            if (iter[0] <= cur[1]) {
                cur[1] = Math.max(cur[1], iter[1]);
            } else {
                res.add(cur);
                cur = iter;
            }
        }
        if (!res.contains(cur))
            res.add(cur);
        return res.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        So56 so = new So56();
        int[][] input = new int[][]{{1,3},{2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(so.merge(input)));
        input = new int[][]{{1,4}, {4,5}};
        System.out.println(Arrays.deepToString(so.merge(input)));
    }
}
