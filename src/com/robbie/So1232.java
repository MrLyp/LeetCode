package com.robbie;

public class So1232 {
    public boolean checkStraightLine(int[][] coordinates) {
        if (coordinates == null || coordinates.length == 0 || coordinates[0].length == 0)
            return false;
        if (coordinates.length == 2)
            return true;
        double rate = Math.abs(calRate(coordinates[1], coordinates[0]));
        for (int i = 2; i < coordinates.length; i++) {
            double nRate = Math.abs(calRate(coordinates[i], coordinates[0]));
            if (Math.abs(nRate - rate) > 1e-6) {
                return false;
            }
        }
        return true;
    }

    private double calRate(int[] p1, int[] p2) {
        return (double)(p2[1] - p1[1]) / (p2[0] - p1[0]);
    }

    public static void main(String[] args) {
        So1232 so = new So1232();
        int[][] co = new int[][]{{1,2},{2,3},{3,4},{4,5},{5,6},{6,7}};
        System.out.println(so.checkStraightLine(co));
        co = new int[][]{{1,1},{2,2},{3,4},{4,5},{5,6},{7,7}};
        System.out.println(so.checkStraightLine(co));
        co = new int[][]{{-7,-3},{-7,-1},{-2,-2},{0,-8},{2,-2},{5,-6},{5,-5},{1,7}};
        System.out.println(so.checkStraightLine(co));
    }
}
