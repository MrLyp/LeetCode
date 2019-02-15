package com.robbie;

import java.util.Arrays;

public class So213 {

    public int rob(int[] nums) {
        if (null == nums || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];

        int[] num1 = Arrays.copyOfRange(nums, 0, nums.length - 1);
        int[] num2 = Arrays.copyOfRange(nums, 1, nums.length);
        return Math.max(robStraight(num1), robStraight(num2));
    }

    public int robStraight(int[] nums) {
        int length = nums.length;
        if (length == 0)
            return 0;
        if (length == 1)
            return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }

    public static void main(String[] args) {
        So213 so = new So213();
        check(so.rob(new int[]{2, 3, 2}), 3);
        check(so.rob(new int[]{1, 2, 3, 1}), 4);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
