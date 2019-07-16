package com.robbie;

public class So26 {

    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0)
            return 0;
        int sum = 1;
        int index = 1;
        int last = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != last) {
                last = nums[i];
                nums[index] = nums[i];
                index = index + 1;
                sum++;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        So26 so = new So26();
        int[] nums = new int[]{1,1,2};
        int res = so.removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }
}
