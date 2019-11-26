package com.robbie;

public class So493 {
    public int reversePairs(int[] nums) {
        return mergeSort(nums, 0, nums.length - 1);
    }

    private int mergeSort(int[] nums, int start, int end) {
        if (start >= end)
            return 0;
        int mid = (start + end) / 2;
        int sum = mergeSort(nums, start, mid) + mergeSort(nums, mid + 1, end);

        int i = start;
        int j = mid + 1;
        while (i <= mid) {
            while (j <= end && (long)nums[i] > (long)nums[j] * 2) {
                j++;
            }
            sum += j - mid - 1;
            i++;
        }

        i = start;
        j = mid + 1;
        int t = 0;
        int[] temp = new int[end - start + 1];
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
        So493 so = new So493();
        System.out.println(so.reversePairs(new int[]{1, 3, 2, 3, 1}));
        System.out.println(so.reversePairs(new int[]{2, 4, 3, 5, 1}));
        System.out.println(so.reversePairs(new int[]{2147483647,2147483647,2147483647,2147483647,2147483647,2147483647}));
    }
}
