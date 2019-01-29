package com.robbie;

import java.util.Arrays;

public class So189 {
    public void rotate(int[] nums, int k) {
        while (k-- > 0) {
            System.out.println(Arrays.toString(nums));
            rotate(nums);
        }
    }

    private void rotate(int[] nums) {
        int length = nums.length;
        int temp = nums[length -1];
        for (int i = length - 1; i > 0; i--) {
            nums[i] = nums[i - 1];
        }
        nums[0] = temp;
    }

    public static void main(String[] args) {
        So189 so = new So189();
        int[] nums = new int[]{1, 2, 3, 4, 5, 6, 7};
        so.rotate(nums, 3);
        check(nums, new int[]{5, 6, 7, 1, 2, 3, 4});
        nums = new int[]{-1, -100, 3, 99};
        so.rotate(nums, 2);
        check(nums, new int[]{3, 99, -1, -100});
    }

    private static void check(int[] numbers, int[] expected) {
        if (Arrays.equals(numbers, expected)) {
            System.out.println(Arrays.toString(numbers) + " pass");
        } else {
            throw new RuntimeException(Arrays.toString(numbers) + " failed");
        }
    }
}
