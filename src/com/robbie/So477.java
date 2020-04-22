package com.robbie;

public class So477 {
    public int totalHammingDistance(int[] nums) {
        int sum = 0;
        int mask;
        for (int i = 0; i < 32; i++) {
            int count = 0;
            mask = 1 << i;
            for (int j = 0; j < nums.length; j++) {
                if ((nums[j] & mask) != 0)
                    count++;
            }
            sum += count * (nums.length - count);
        }
        return sum;
    }

    public static void main(String[] args) {
        So477 so = new So477();
        System.out.println(so.totalHammingDistance(new int[]{4, 14, 2}));
    }
}
