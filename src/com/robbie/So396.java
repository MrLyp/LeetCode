package com.robbie;

public class So396 {
    public int maxRotateFunction(int[] A) {
        int sum = 0;
        int f0 = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            sum += A[i];
            f0 += i * A[i];
        }
        int max = f0;
        for (int k = 1; k < length; k++) {
            int fk = f0 + sum - length * A[length - k];
            max = Math.max(max, fk);
            f0 = fk;
        }
        return max;
    }

    public static void main(String[] args) {
        So396 so = new So396();
        System.out.println(so.maxRotateFunction(new int[]{4, 3, 2, 6}));
    }
}
