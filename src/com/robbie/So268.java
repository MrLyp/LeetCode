package com.robbie;

import java.util.Arrays;

public class So268 {
    public int missingNumber(int[] nums) {
        int x = nums[0] ^ 0;
        for (int i = 1; i < nums.length; i++) {
            x = x ^ nums[i] ^ i;
        }
        x ^= nums.length;
        return x;
    }

    public static void main(String[] args) {
        So268 so = new So268();
        System.out.println(so.missingNumber(new int[]{3, 0, 1}));
        System.out.println(so.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 8, 0, 1}));
        System.out.println(so.missingNumber(new int[]{2, 7, 4, 5, 9, 0, 6, 8, 3}));
    }
}
