package com.robbie;

public class So209 {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null) {
            return 0;
        }
        int start = 0;
        int end = 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        while (end < nums.length && start <= end) {
            sum += nums[end++];
            while (sum >= s) {
                min = Math.min(min, end - start);
                sum -= nums[start++];
            }
        }
        if (min == Integer.MAX_VALUE)
            return 0;
        return min;
    }

    public static void main(String[] args) {
        So209 so = new So209();
        check(so.minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}), 2);
        check(so.minSubArrayLen(28, new int[]{2, 3, 1, 2, 4, 3}), 1);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
