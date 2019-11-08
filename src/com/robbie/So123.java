package com.robbie;

import java.util.Arrays;

public class So123 {
    // TLE: 199 / 200 test cases passed.
    public int maxProfitBad(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int length = prices.length;
        int[][] dp = new int[length][length];
        for (int i = 0; i < length; i++) {
            for (int j = i; j < length; j++) {
                dp[i][j] = Math.max(dp[i][j], prices[j] - prices[i]);
            }
        }
        int max = 0;
        for (int k = 0; k < length; k++) {
            int leftMax = 0;
            for (int i = 0; i < length; i++) {
                for (int j = i; j < k; j++) {
                    leftMax = Math.max(leftMax, dp[i][j]);
                }
            }
            int rightMax = 0;
            for (int i = k; i < length; i++) {
                for (int j = i; j < length; j++) {
                    rightMax = Math.max(rightMax, dp[i][j]);
                }
            }
            max = Math.max(max, leftMax + rightMax);
        }
        return max;
    }

    public int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1)
            return 0;
        int n = prices.length;
        int[] f = new int[n];
        int[] g = new int[n];
        int profit = 0;
        f[0] = 0;
        g[0] = 0;
        int min = prices[0];
        for (int i = 1; i < n; i++) {
            f[i] = Math.max(f[i-1], prices[i] - min);
            min = Math.min(prices[i], min);
        }
        int max = prices[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            g[i] = Math.max(g[i + 1], max - prices[i]);
            max = Math.max(prices[i], max);
        }
        for (int i = 0; i < prices.length; i++)
            profit = Math.max(profit, f[i] + g[i]);
        return profit;
    }

    public static void main(String[] args) {
        So123 so = new So123();
        System.out.println(so.maxProfit(new int[]{1,2,3,4,5}));
    }
}
