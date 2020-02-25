package com.robbie;

import java.util.Arrays;
import java.util.Stack;

public class So456 {
    public boolean find132pattern(int[] nums) {
        if (nums == null || nums.length < 3)
            return false;
        int[] min = new int[nums.length];
        min[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[min[i - 1]] >= nums[i]) {
                min[i] = i;
            } else {
                min[i] = min[i - 1];
            }
        }
        System.out.println(Arrays.toString(min));
        Stack<Integer> stack = new Stack<>();
        for(int i = nums.length - 1; i >= 0; i--) {
            if (min[i] < i) {
                while (!stack.isEmpty() && nums[stack.peek()] <= nums[min[i]]) {
                    stack.pop();
                }
                if (!stack.isEmpty() && nums[stack.peek()] < nums[i])
                    return true;
                stack.push(i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        So456 so = new So456();
        System.out.println(so.find132pattern(new int[]{1, 0, 1, -4, -3}));
        System.out.println(so.find132pattern(new int[]{3, 1, 4, 2}));
        System.out.println(so.find132pattern(new int[]{1, 2, 3, 4}));
        System.out.println(so.find132pattern(new int[]{4, 1, 3, 2}));
        System.out.println(so.find132pattern(new int[]{3,5,0,3,4}));
    }
}
