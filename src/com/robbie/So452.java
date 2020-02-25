package com.robbie;

import java.util.Arrays;
import java.util.Comparator;

public class So452 {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        Arrays.sort(points, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0])
                    return o1[1] - o2[1];
                return o1[0] - o2[0];
            }
        });
        int start = 1;
        int count = 1;
        int right = points[0][1];
        while (start < points.length) {
            if (points[start][0] <= right) {
                right = Math.min(right, points[start][1]);
            } else {
                right = points[start][1];
                count++;
            }
            start++;
        }
        return count;
    }

    public static void main(String[] args) {
        So452 so = new So452();
        System.out.println(so.findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        System.out.println(so.findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
    }
}
