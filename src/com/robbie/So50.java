package com.robbie;

public class So50 {
    public double myPow(double x, int n) {
        if (x == 0)
            return 0;
        if (x == 1)
            return 1;
        if (n < 0) {
            if (n == Integer.MIN_VALUE)
                return 1 / (pow(x, Integer.MAX_VALUE) * x);
            return 1 / pow(x, -n);
        } else
            return pow(x, n);
    }

    private double pow(double x, int n) {
        if (n == 0)
            return 1;
        if (n % 2 == 0) {
            double res = pow(x, n / 2);
            return res * res;
        } else {
            double res = pow(x, (n - 1) / 2);
            return res * res * x;
        }
    }

    public static void main(String[] args) {
        So50 so = new So50();
        System.out.println(so.myPow(2.0, 10));
        System.out.println(so.myPow(2.1, 3));
        System.out.println(so.myPow(2.0, -2));
        System.out.println(so.myPow(2.00000, -2147483648));
    }
}
