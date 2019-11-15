package com.robbie;

import java.util.Arrays;

public class So287 {
    public int findDuplicate(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        for (int i = 0; i < nums.length;) {
            if (i+1 == nums[i]) {
                i++;
                continue;
            }
            int index = nums[i] -1;
            if (nums[index] == nums[i])
                return nums[i];
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }

        return 0;
    }

    public static void main(String[] args) {
        So287 so = new So287();
        System.out.println(so.findDuplicate(new int[]{8,7,1,10,17,15,18,11,16,9,19,12,5,14,3,4,2,13,18,18}));
        System.out.println(so.findDuplicate(new int[]{1,3,4,2,2}));
    }
}
