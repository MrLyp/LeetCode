package com.robbie;

public class So198 {
    public int rob(int[] nums) {
//        return search(0, nums);
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

    // TLE
    private int search(int index, int[] nums) {
        if (index >= nums.length)
            return 0;
        if (index == nums.length - 1)
            return nums[index];
        return Math.max(nums[index] + search(index + 2, nums), search(index + 1, nums));
    }

    public static void main(String[] args) {
        So198 so = new So198();
        check(so.rob(new int[]{1, 2, 3, 1}), 4);
        check(so.rob(new int[]{2, 7, 9, 3, 1}), 12);
        check(so.rob(new int[]{114,117,207,117,235,82,90,67,143,146,53,108,200,91,80,223,58,170,110,236,81,90,222,160,165,195,187,199,114,235,197,187,69,129,64,214,228,78,188,67,205,94,205,169,241,202,144,240}), 4173);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
