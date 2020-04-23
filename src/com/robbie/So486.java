package com.robbie;


public class So486 {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int s = nums.length - 1; s >= 0; s--) {
            for (int e = s + 1;e < nums.length; e++) {
                dp[s][e] = Math.max(nums[s] - dp[s + 1][e], nums[e] - dp[s][e - 1]);
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }

    public static void main(String[] args) {
        So486 so = new So486();
        System.out.println(so.PredictTheWinner(new int[]{1, 5, 2}));
        System.out.println(so.PredictTheWinner(new int[]{1, 5, 233, 7}));
    }

}
