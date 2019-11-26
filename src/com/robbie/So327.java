package com.robbie;

public class So327 {

    public int countRangeSum(int[] nums, int lower, int upper) {
        long[] sum = new long[nums.length+1];
        for (int i = 1; i < sum.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        return mergeSort(sum, 0, sum.length - 1, lower, upper);
    }

    private int mergeSort(long[] nums, int start, int end, int lower, int upper) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        int sum = mergeSort(nums, start, mid, lower, upper) + mergeSort(nums, mid + 1, end, lower, upper);

        int i = start;
        int j = mid + 1;
        int low = j, up = j;
        while (i <= mid) {
            while (low <= end && nums[low] - nums[i] < lower)
                low++;
            while (up <= end && nums[up] - nums[i] <= upper)
                up++;
            sum += up - low;
            i++;
        }

        i = start;
        j = mid + 1;
        int t = 0;
        long[] temp = new long[end - start + 1];
        while (i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[t++] = nums[j++];
            } else {
                temp[t++] = nums[i++];
            }
        }
        while (i <= mid) {
            temp[t++] = nums[i++];
        }
        while (j <= end) {
            temp[t++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, start, temp.length);
        return sum;
    }

    public static void main(String[] args) {
        So327 so = new So327();
        System.out.println(so.countRangeSum(new int[]{-2, 5, -1}, -2, 2));
    }
}
