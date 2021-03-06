package com.robbie;

public class So42 {
    public int trap(int[] height) {
        if (height.length == 0)
            return 0;
        int[] left = new int[height.length];
        int[] right = new int[height.length];
        left[0] = height[0];
        right[height.length - 1] = height[height.length - 1];
        for (int i = 1; i < height.length; i++) {
            left[i] = Math.max(height[i], left[i - 1]);
        }
        for (int i = height.length - 2; i >= 0; i--) {
            right[i] = Math.max(height[i], right[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < height.length - 1; i++) {
            sum += Math.min(left[i], right[i]) - height[i];
        }
        return sum;
    }

    public static void main(String[] args) {
        So42 so = new So42();
        System.out.println(so.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
