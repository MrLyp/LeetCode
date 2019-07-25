package com.robbie;

import java.util.Arrays;

/**
 * Created by leeyunpeng on 2019/7/25.
 */
public class So283 {
    public void moveZeroes(int[] nums) {
        if (nums == null || nums.length == 0)
            return;
        int p = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0)
                nums[p++] = nums[i];
        }
        for (int i = p; i < nums.length; i++)
            nums[i] = 0;
    }

    public static void main(String[] args) {
        So283 so = new So283();
        int[] nums = new int[]{0,1,0,3,12};
        so.moveZeroes(nums);
        System.out.println(Arrays.toString(nums));
    }
}
