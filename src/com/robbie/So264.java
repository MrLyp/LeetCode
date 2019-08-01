package com.robbie;

public class So264 {
    public int nthUglyNumber(int n) {
        int k = 1;
        int f2 = 0;
        int f3 = 0;
        int f5 = 0;
        int[] u = new int[n];
        u[0] = 1;
        while (k < n) {
            u[k] = Math.min(u[f2] * 2, Math.min(u[f3] * 3, u[f5] * 5));
            while(u[f2] * 2 <= u[k])
                f2++;
            while(u[f3] * 3 <= u[k])
                f3++;
            while(u[f5] * 5 <= u[k])
                f5++;
            k++;
        }
        return u[n - 1];
    }

    public static void main(String[] args) {
        So264 so = new So264();
        for (int i = 1 ; i <= 10; i++) {
            System.out.println(so.nthUglyNumber(i));
        }
    }
}
