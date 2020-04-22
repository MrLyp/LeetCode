package com.robbie;

public class So478 {
    class Solution {

        private double r;
        private double x;
        private double y;

        public Solution(double radius, double x_center, double y_center) {
            r = radius;
            x = x_center;
            y = y_center;
        }

        public double[] randPoint() {
            double degree = Math.random() * 360;
            // 可能是精度问题，这里必须要做开方
            double l = Math.sqrt(Math.random()) * r;

            double rpx = Math.cos(degree) * l + x;
            double rpy = Math.sin(degree) * l + y;
            return new double[]{rpx, rpy};
        }
    }
}
