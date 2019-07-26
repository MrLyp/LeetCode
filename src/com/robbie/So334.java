package com.robbie;

public class So334 {
    public boolean increasingTriplet(int[] nums) {
        return lengthOfLIS(nums) >= 3;
    }

    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int max = 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }

    public static void main(String[] args) {
        So334 so = new So334();
        System.out.println(so.increasingTriplet(new int[]{1,2,3,4,5}));
        System.out.println(so.increasingTriplet(new int[]{5, 4,3,2,1}));
    }
}
