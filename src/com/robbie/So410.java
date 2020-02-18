package com.robbie;

import java.util.Arrays;

public class So410 {
    int[][] dp;
    int[] presum;

    public int splitArray(int[] nums, int m) {
        dp = new int[nums.length][m];
        presum = new int[nums.length + 1];
        presum[0] = nums[0];
        for (int i = 1; i <= nums.length; i++) {
            presum[i] = presum[i - 1] + nums[i - 1];
        }
        for (int i = 0; i < nums.length; i++) {
            for (int k = 0; k < m; k++) {
                dp[i][k] = -1;
            }
        }
        calc(0, m - 1, nums.length, presum);
        return dp[0][m - 1];
    }

    private int calc(int start, int m, int len, int[] presum) {
        if (m == 0) {
            dp[start][m] = presum[len] - presum[start];
            return dp[start][m];
        }
        if (dp[start][m] >= 0)
            return dp[start][m];
        int min = Integer.MAX_VALUE;
        for (int i = start + 1; i < len; i++) {
            int left = presum[i] - presum[start];
            int right = calc(i, m - 1, len, presum);
            if (right < 0)
                continue;
            min = Math.min(min, Math.max(left, right));
        }
        dp[start][m] = min;
        return min;
    }

    public static void main(String[] args) {
        So410 so = new So410();
        System.out.println(so.splitArray(new int[]{7, 2, 5, 10, 8}, 2));
        System.out.println(so.splitArray(new int[]{1, 4, 4}, 3));
        System.out.println(so.splitArray(new int[]{1, Integer.MAX_VALUE}, 2));
        System.out.println(so.splitArray(new int[]{2, 3, 1, 2, 4, 3}, 5));
    }
}
