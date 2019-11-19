package com.robbie;

import java.util.Arrays;

public class So313 {
    public int nthSuperUglyNumber(int n, int[] primes) {
        if (n <= 0 || primes == null)
            return 1;
        int[] result = new int[n];
        int[] next = new int[primes.length];
        result[0] = 1;
        int k = 1;
        while(k < n) {
            int min = Integer.MAX_VALUE;
            for (int i = 0; i < primes.length; i++) {
                min = Math.min(min, primes[i] * result[next[i]]);
            }
            result[k] = min;
            k++;
            for (int i = 0; i < primes.length; i++) {
                while(result[next[i]] * primes[i] <= min)
                    next[i]++;
            }
        }
        return result[n - 1];
    }

    public static void main(String[] args) {
        So313 so = new So313();
        System.out.println(so.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
