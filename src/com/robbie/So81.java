package com.robbie;

public class So81 {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0)
            return false;
        int l = 0;
        int r = nums.length - 1;
        while (l <= r) {
            if (nums[l] == target || nums[r] == target)
                return true;
            if (nums[l] == nums[r]) {
                l++;
                continue;
            }
            int mid = (l + r) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[l] == nums[mid]) {
                l++;
                continue;
            }
            if (nums[mid] == nums[r]) {
                r--;
                continue;
            }
            if (nums[mid] > target) {
                if (nums[l] <= target || nums[l] > nums[mid]) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            } else {
                if (nums[r] >= target || nums[r] <= nums[mid]) {
                    l = mid + 1;
                } else {
                    r = mid - 1;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        So81 so = new So81();
        System.out.println(so.search(new int[]{2, 3, 5, 6, 0, 0, 1, 2}, 3));
    }
}
