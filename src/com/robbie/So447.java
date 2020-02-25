package com.robbie;

import java.util.HashMap;
import java.util.Map;

public class So447 {
    public int numberOfBoomerangs(int[][] points) {
        Map<Double, Integer> map;
        int sum = 0;
        for (int i = 0; i < points.length; i++) {
            map = new HashMap<>();
            for (int j = 0; j < points.length; j++) {
                if (i == j)
                    continue;
                double dis = Math.sqrt(Math.pow(points[j][0] - points[i][0], 2) + Math.pow(points[j][1] - points[i][1], 2));
                map.put(dis, map.getOrDefault(dis, 0) + 1);
            }
            for (Double d : map.keySet()) {
                int pointsCount = map.get(d);
                sum += pointsCount * (pointsCount - 1);
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        So447 so = new So447();
        System.out.println(so.numberOfBoomerangs(new int[][]{{0, 0}, {1, 0}, {2, 0}}));
    }
}
