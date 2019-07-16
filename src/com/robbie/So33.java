package com.robbie;

public class So33 {

    public int search(int[] nums, int target) {
        return search(nums, 0, nums.length - 1, target);
    }

    private int search(int[] nums, int start, int end, int target) {
        if (start < 0 || end < 0 || start > end)
            return -1;
        int mid = (start + end) / 2;
        int res;
        if (nums[mid] < nums[start]) {
            res = binarySearch(nums, mid + 1, end, target);
            if (res < 0)
                res = search(nums, start, mid, target);
        } else {
            res = binarySearch(nums, start, mid, target);
            if (res < 0)
                res = search(nums, mid + 1, end, target);
        }
        return res;
    }

    private int binarySearch(int[] nums, int start, int end, int target) {
        int low = start;
        int high = end;

        while (low <= high) {
            int mid = (low + high) >>> 1;
            int midVal = nums[mid];

            if (midVal < target)
                low = mid + 1;
            else if (midVal > target)
                high = mid - 1;
            else
                return mid;
        }
        return -1;
    }

    public static void main(String[] args) {
        So33 so = new So33();
        int[] nums = new int[]{4, 5, 6, 7, 0, 1, 2};
        System.out.println(so.search(nums, 0));
    }
}
