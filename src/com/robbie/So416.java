package com.robbie;

public class So416 {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int i : nums)
            sum += i;
        if (sum % 2 == 1)
            return false;
        return isSumSet(nums, sum / 2);
    }

    public boolean isSumSet(int[] nums, int target) {
        boolean[] subset = new boolean[target + 1];
        subset[0] = true;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j > 0; j--) {
                if (j >= nums[i])
                    subset[j] |= subset[j - nums[i]];
            }
        }
        return subset[target];
    }

    public static void main(String[] args) {
        So416 so = new So416();
        System.out.println(so.canPartition(new int[]{1, 5, 5, 11}));
        System.out.println(so.canPartition(new int[]{1, 2, 3, 5}));
    }
}
