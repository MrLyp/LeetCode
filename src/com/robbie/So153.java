package com.robbie;

public class So153 {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return nums[0];
        int l = 0;
        int r = nums.length;
        if (nums[r - 1] > nums[l])
            return nums[l];
        while(l < r) {
            int mid = (l + r) / 2;
            if (mid <= nums.length - 2 && nums[mid] > nums[mid + 1])
                return nums[mid+1];
            if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return nums[l];
    }

    public static void main(String[] args) {
        So153 so = new So153();
        System.out.println(so.findMin(new int[]{4,5,6,7,0,1,2}));
        System.out.println(so.findMin(new int[]{2,1}));
    }
}
