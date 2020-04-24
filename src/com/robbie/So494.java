package com.robbie;

public class So494 {
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) sum += num;
        if (S > sum) return 0;
        int[][] dp = new int[nums.length + 1][2 * sum + 1];
        dp[0][sum] = 1;
        // from -sum to sum
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 0; j <= 2 * sum; j++) {
                if (j >= nums[i - 1])
                    dp[i][j] += dp[i - 1][j - nums[i - 1]];
                if (j + nums[i - 1] <= 2 * sum)
                    dp[i][j] += dp[i - 1][j + nums[i - 1]];
            }
        }
        return dp[nums.length][S + sum];
    }

    public static void main(String[] args) {
        So494 so = new So494();
        System.out.println(so.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
    }
}
