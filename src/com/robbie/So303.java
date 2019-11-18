package com.robbie;

public class So303 {
    static class NumArray {

        private int[] sum;

        private int[] nums;

        public NumArray(int[] nums) {
            this.nums = nums;
            sum = new int[nums.length];
            if (nums.length == 0)
                return;
            sum[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                sum[i] = sum[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            return sum[j] - sum[i] + nums[i];
        }
    }

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
        System.out.println(array.sumRange(0, 2));
        System.out.println(array.sumRange(2, 5));
        System.out.println(array.sumRange(0, 5));

    }
}
