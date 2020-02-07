package com.robbie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class So368 {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int length = nums.length;
        int max = Integer.MIN_VALUE;
        int maxIndex = length - 1;
        int[] dp = new int[length];
        int[] path = new int[length];
        for (int i = 0; i < length; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && dp[j] + 1 > dp[i]) {
                    dp[i] = dp[j] + 1;
                    path[i] = j;
                }
            }
            if (dp[i] > max) {
                max = dp[i];
                maxIndex = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        int i = 0;
        while (i++ < max) {
            res.add(nums[maxIndex]);
            maxIndex = path[maxIndex];
        }
        Collections.sort(res);
        return res;
    }

    public static void main(String[] args) {
        So368 so = new So368();
        System.out.println(so.largestDivisibleSubset(new int[]{1, 2, 3}));
        System.out.println(so.largestDivisibleSubset(new int[]{1, 2, 4, 8}));
    }
}
