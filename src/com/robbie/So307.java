package com.robbie;

public class So307 {
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

        public void update(int i, int val) {
            for (int j = i; j < nums.length; j++) {
                sum[j] += val - nums[i];
            }
            nums[i] = val;
        }

        public int sumRange(int i, int j) {
            return sum[j] - sum[i] + nums[i];
        }
    }

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{1,3,5});
        System.out.println(array.sumRange(0, 2));
        array.update(1,2);
        System.out.println(array.sumRange(0, 2));
    }
}
