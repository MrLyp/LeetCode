package com.robbie;

public class So377 {
    public int combinationSum4(int[] nums, int target) {
        Integer[] dp = new Integer[target + 1];
        return comb(nums, target, dp);
    }

    private int comb(int[] nums, int target, Integer[] dp) {
        if (dp[target] != null)
            return dp[target];
        if (0 == target) {
            return 1;
        }
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= target) {
                count += comb(nums, target - nums[i], dp);
                dp[target] = count;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        So377 so = new So377();
        System.out.println(so.combinationSum4(new int[]{1, 2, 3}, 35));
    }
}
