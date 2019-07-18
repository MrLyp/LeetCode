package com.robbie;

public class So80 {
    public int removeDuplicates(int[] nums) {
        int count = 0;
        int last = Integer.MIN_VALUE;
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 2 && nums[i] == nums[i - 1] && nums[i] == nums[i - 2] && count >=2)
                continue;
            if (last == nums[i])
                count++;
            else
                count = 1;
            last = nums[i];
            nums[index] = nums[i];
            index++;
        }
        return index;
    }

    public static void main(String[] args) {
        So80 so = new So80();
        int[] nums = new int[]{0,0,1,1,1,1,2,3,3};
        int res = so.removeDuplicates(nums);
        System.out.println(res);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i]);
        }
    }
}
