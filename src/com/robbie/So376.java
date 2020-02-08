package com.robbie;

public class So376 {

    public int wiggleMaxLength(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        if (nums.length == 1)
            return 1;
        int[] diff = new int[nums.length - 1];
        for (int i = 1; i < nums.length; i++) {
            diff[i - 1] = nums[i] - nums[i - 1];
        }
        int start = 0;
        while(start < diff.length && diff[start] == 0) {
            start++;
        }
        if (start == diff.length)
            return 1;
        int length = 1;
        boolean positive = diff[start] > 0;
        for (int i = start + 1; i < diff.length; i++) {
            if (positive) {
                if (diff[i] >= 0)
                    continue;
            } else {
                if (diff[i] <= 0)
                    continue;
            }
            positive = diff[i] > 0;
            length++;
        }
        return length + 1;
    }

    public static void main(String[] args) {
        So376 so = new So376();
        System.out.println(so.wiggleMaxLength(new int[]{1,7,4,9,2,5}));
        System.out.println(so.wiggleMaxLength(new int[]{1,17,5,10,13,15,10,5,16,8}));
        System.out.println(so.wiggleMaxLength(new int[]{1,2}));
        System.out.println(so.wiggleMaxLength(new int[]{0, 0}));
    }
}
