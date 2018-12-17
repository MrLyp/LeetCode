package com.robbie;

import java.util.Arrays;

// https://leetcode.com/problems/majority-element/
public class So169 {

    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public static void main(String[] args) {
        check(3, new int[]{3, 2, 3});
        check(2, new int[]{2, 2, 1, 1, 1, 2, 2});
    }

    private static void check(int n, int[] numbers) {
        So169 so = new So169();
        int res = so.majorityElement(numbers);
        if (res != n) {
            throw new IllegalStateException(n + "," + res);
        } else {
            System.out.println(n + "," + res + ", pass");
        }
    }
}
