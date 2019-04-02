package com.robbie;

public class So300 {

    public int lengthOfLIS(int[] nums) {
        int max = 0;
        int[] dp = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            max = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    max = Math.max(max, dp[j] + 1);
                }
            }
            dp[i] = max;
        }
        max = 0;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, dp[i]);
        }
        return max;
    }

    public static void main(String[] args) {
        So300 so = new So300();
        check(so.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18}), 4);
        check(so.lengthOfLIS(new int[]{-2, -1}), 2);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
