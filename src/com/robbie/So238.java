package com.robbie;

import java.util.Arrays;

public class So238 {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        result[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        int mult = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            result[i] *= mult;
            mult *= nums[i];
        }
        return result;
    }

    public static void main(String[] args) {
        So238 so = new So238();
        System.out.println(Arrays.toString(so.productExceptSelf(new int[]{1, 2, 3, 4})));
    }
}
