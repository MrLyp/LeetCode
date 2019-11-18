package com.robbie;

import java.util.Arrays;

public class So307 {
    static class NumArrayBrute {

        private int[] sum;

        private int[] nums;

        public NumArrayBrute(int[] nums) {
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

    static class NumArray {

        private int[] array;

        private int[] nums;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0)
                return;
            this.nums = nums;
            int n = nums.length;
            array = new int[n * 4];
            build(nums, 0, n - 1, 0);
            System.out.println(Arrays.toString(array));
        }

        private void build(int[] nums, int start, int end, int index) {
            if (start > end)
                return;
            if (start == end) {
                array[index] = nums[start];
                return;
            }
            int mid = (start + end) / 2;
            build(nums, start, mid, index * 2 + 1);
            build(nums, mid + 1, end, index * 2 + 2);
            array[index] = array[2 * index + 1] + array[2 * index + 2];
        }

        public void update(int i, int val) {
            update(0, nums.length - 1, 0, i, val);
        }

        private void update(int start, int end, int index, int i, int val) {
            if (start == end) {
                array[index] = val;
                return;
            }
            int mid = (start + end) / 2;
            if (i <= mid)
                update(start, mid, index * 2 + 1, i, val);
            else
                update(mid + 1, end, index * 2 + 2, i, val);
            array[index] = array[2 * index + 1] + array[2 * index + 2];
        }

        public int sumRange(int i, int j) {
            return sumRange(0, nums.length - 1, i, j, 0);
        }

        private int sumRange(int start, int end, int i, int j, int index) {
            if (start > j || end < i)
                return 0;
            if (i <= start && end <= j) {
                return array[index];
            }
            int mid = (start + end) / 2;
            return sumRange(start, mid, i, j, index * 2 + 1) + sumRange(mid + 1, end, i, j, index * 2 + 2);
        }
    }

    public static void main(String[] args) {
        NumArray array = new NumArray(new int[]{1, 3, 5});
        System.out.println(array.sumRange(0, 2));
        array.update(1, 2);
        System.out.println(array.sumRange(0, 2));
    }
}
