package com.robbie;

import java.util.Arrays;

public class So75 {

    public void sortColors(int[] nums) {
        if (nums == null) {
            return;
        }
        int c1 = 0, c2 = 0, c0 = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                c0++;
            else if (nums[i] == 1)
                c1++;
            else
                c2++;
        }
        int index = 0;
        while (c0-- > 0) {
            nums[index++] = 0;
        }
        while (c1-- > 0) {
            nums[index++] = 1;
        }
        while (c2-- > 0) {
            nums[index++] = 2;
        }
    }

    public static void main(String[] args) {
        So75 so = new So75();
        int[] nums = new int[]{2, 0, 2, 1, 2, 0};
        so.sortColors(nums);
        System.out.println(Arrays.toString(nums));
    }
}
