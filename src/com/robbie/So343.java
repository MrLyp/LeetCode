package com.robbie;

import java.util.Arrays;
import java.util.Map;

public class So343 {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            int max = 0;
            for (int j = 1; j < i; j++) {
                max = max(max, j * (i - j), j * dp[i - j], dp[j] * (i - j), dp[j] * dp[i - j]);
            }
            dp[i] = max;
        }
//        System.out.println(Arrays.toString(dp));
        return dp[n];
    }

    private int max(int... array) {
        int max = 0;
        for (int item : array)
            max = Math.max(max, item);
        return max;
    }

    public static void main(String[] args) {
        So343 so = new So343();
        System.out.println(so.integerBreak(10));
    }
}
