package com.robbie;

import java.util.Arrays;

public class So312 {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] newNums = new int[n + 2];
        newNums[0] = 1;
        newNums[n + 1] = 1;
        for (int i = 0; i < n; i++) {
            newNums[i + 1] = nums[i];
        }
        int[][] dp = new int[n + 2][n + 2];
        for (int l = 1; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                int max = 0;
                for (int k = i; k <= j; k++) {
                    int left = newNums[i - 1];
                    int right = newNums[j + 1];
                    max = Math.max(max, left * newNums[k] * right + dp[i][k - 1] + dp[k + 1][j]);
                }
                dp[i][j] = max;
            }
        }

//        System.out.println(Arrays.deepToString(dp));
        return dp[1][n];
    }

    public static void main(String[] args) {
        So312 so = new So312();
        System.out.println(so.maxCoins(new int[]{3, 1, 5, 8}));
    }
}
