package com.robbie;

import java.util.*;

public class So406 {

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0];
            }
        });

        int[][] res = new int[people.length][];
        for (int[] p : people) {
            int start = 0;
            int higher = 0;
            while (true) {
                if (res[start] == null && higher >= p[1])
                    break;
                if (res[start] == null || res[start][0] >= p[0]) {
                    higher++;
                }
                start++;
            }
            res[start] = p;
        }
        return res;
    }

    public static void main(String[] args) {
        So406 so = new So406();
        System.out.println(Arrays.deepToString(so.reconstructQueue(new int[][]{{7, 0}, {4, 4}, {7, 1}, {5, 0}, {6, 1}, {5, 2}})));
    }
}
