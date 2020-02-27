package com.robbie;

import java.util.Arrays;

public class So462 {
    public int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length - 1;
        int m = nums[(len + 1) / 2];
        int sum = 0;
        for (int i = 0; i <= len; i++) {
            sum += Math.abs(nums[i] - m);
        }
        return sum;
    }

    public static void main(String[] args) {
        So462 so = new So462();
        System.out.println(so.minMoves2(new int[]{1,0,0,8,6}));
    }
}
