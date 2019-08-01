package com.robbie;

import java.util.Arrays;

public class So260 {
    public int[] singleNumber(int[] nums) {
        if (nums == null || nums.length == 0)
            return null;
        int xor = nums[0];
        for (int i = 1; i < nums.length; i++) {
            xor = xor ^ nums[i];
        }
        int i = 0;
        while ((xor & 1) == 0) {
            xor = xor >> 1;
            i++;
        }
        int num1, num2;
        num1 = num2 = Integer.MIN_VALUE;
        for (int j = 0; j < nums.length; j++) {
            if (((nums[j] >> i) & 1) == 1) {
                if (num1 == Integer.MIN_VALUE)
                    num1 = nums[j];
                else
                    num1 = num1 ^ nums[j];
            } else {
                if (num2 == Integer.MIN_VALUE)
                    num2 = nums[j];
                else
                    num2 = num2 ^ nums[j];
            }
        }
        return new int[]{num1, num2};
    }

    public static void main(String[] args) {
        So260 so = new So260();
        System.out.println(Arrays.toString(so.singleNumber(new int[]{1, 2, 1, 3, 2, 5})));
    }
}
