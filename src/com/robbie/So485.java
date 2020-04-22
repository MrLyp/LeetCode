package com.robbie;

public class So485 {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null)
            return 0;
        int left = 0;
        int right = 0;
        int max = 0;
        while (right < nums.length) {
            while (left < nums.length && nums[left] == 0)
                left++;
            right = left;
            while (right < nums.length && nums[right] == 1)
                right++;
            max = Math.max(right - left, max);
            left = right;
        }
        return max;
    }

    public static void main(String[] args) {
        So485 so = new So485();
        System.out.println(so.findMaxConsecutiveOnes(new int[]{1}));
    }
}
