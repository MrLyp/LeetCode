package com.robbie;

import java.util.Arrays;

public class So457 {
    public boolean circularArrayLoop(int[] nums) {
        if (nums == null || nums.length < 2)
            return false;
        for (int i = 0; i < nums.length; i++) {
            if (isCycle(nums.clone(), 0, false, i, i, nums[i] > 0)) {
                return true;
            }
        }
        return false;
    }

    private boolean isCycle(int[] nums, int len, boolean round, int cur, int start, boolean forward) {
        if (nums[cur] == 0)
            return cur == start && round && len > 1;
        int n = nums.length;
        if (nums[cur] != 0 && Math.abs(nums[cur]) % n == 0)
            return false;
        int next = cur + nums[cur];
        if (next < 0 || next >= nums.length)
            round = true;
        next = (next % n + n) % n;
        if (cur == next) {
            nums[cur] = 0;
            return false;
        }
        if (nums[next] != 0 && forward != (nums[next] > 0))
            return false;
        nums[cur] = 0;
        return isCycle(nums, len + 1, round, next, start, forward);
    }

    public static void main(String[] args) {
        So457 so = new So457();
        System.out.println(so.circularArrayLoop(new int[]{2, -1, 1, 2, 2}));
    }
}
