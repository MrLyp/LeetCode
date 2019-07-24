package com.robbie;

import java.util.HashSet;

public class So128 {
    public int longestConsecutive(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0;i < nums.length; i++) {
            set.add(nums[i]);
        }
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i] - 1))
                continue;
            int cur = nums[i];
            int count = 0;
            while(set.contains(cur)) {
                cur++;
                count++;
            }
            max = Math.max(max, count);
        }
        return max;
    }

    public static void main(String[] args) {
        So128 so = new So128();
        System.out.println(so.longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }
}
