package com.robbie;

import java.util.Arrays;

public class So453 {
    /**
     * let final moves is x
     * (n - 1) * x + sum = n * (min - x)
     * x = sum - n * min
     * @param nums
     * @return
     */
    public int minMoves(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for (int i : nums) {
            sum+= i;
            min = Math.min(min, i);
        }
        return sum - nums.length * min;
    }
}
