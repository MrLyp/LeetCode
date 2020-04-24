package com.robbie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

public class So496 {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        if (nums1.length == 0)
            return nums1;
        Stack<Integer> stack = new Stack<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] >= stack.peek())
                stack.pop();
            if (stack.isEmpty()) {
                map.put(nums2[i], -1);
            } else {
                map.put(nums2[i], stack.peek());
            }
            stack.push(nums2[i]);
        }
        int[] res = new int[nums1.length];
        for (int i = 0; i < nums1.length; i++) {
            res[i] = map.getOrDefault(nums1[i], -1);
        }
        return res;
    }

    public static void main(String[] args) {
        So496 so = new So496();
        System.out.println(Arrays.toString(so.nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
        System.out.println(Arrays.toString(so.nextGreaterElement(new int[]{2,4}, new int[]{1,2,3,4})));
    }
}
