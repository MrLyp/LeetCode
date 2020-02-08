package com.robbie;

public class So375 {
    public int getMoneyAmount(int n) {
        int[][] dp = new int[n + 1][n + 1];
        return guess(1, n, dp);
    }

    private int guess(int start, int end, int[][] dp) {
        if (start >= end)
            return 0;
        if (dp[start][end] != 0)
            return dp[start][end];
        int min = Integer.MAX_VALUE;
        for (int i = start; i <= end; i++) {
            int left = guess(start, i - 1, dp) + i;
            int right = guess(i + 1, end, dp) + i;
            min = Math.min(min, Math.max(left, right));
        }
        dp[start][end] = min;
        return min;
    }

    public static void main(String[] args) {
        So375 so = new So375();
        System.out.println(so.getMoneyAmount(10));
    }
}
