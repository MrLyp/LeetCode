package com.robbie;

import java.util.Arrays;

public class So215 {

    public int findKthLargest(int[] nums, int k) {
        return find(nums, 0, nums.length - 1, k);
    }

    private int find(int[] nums, int start, int end, int k) {
        int pivot = partition(nums, start, end);
        if (pivot + 1 == k)
            return nums[pivot];
        else if (pivot + 1 > k) {
            return find(nums, start, pivot - 1, k);
        } else {
            return find(nums, pivot + 1, end, k);
        }
    }

    private int partition(int[] nums, int start, int end) {
        int pivot = nums[start];
        while (start < end) {
            while (nums[end] < pivot && start < end) {
                end--;
            }
            if (start < end) {
                nums[start++] = nums[end];
            }
            while (nums[start] > pivot && start < end) {
                start++;
            }
            if (start < end) {
                nums[end--] = nums[start];
            }
        }
        nums[start] = pivot;
        return start;
    }

    public static void main(String[] args) {
        So215 so = new So215();
        check(so.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2), 5);
        check(so.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4), 4);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
