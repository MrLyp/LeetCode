package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So442 {
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0)
                res.add(index + 1);
            else
                nums[index] = -nums[index];
        }
        return res;
    }

    public static void main(String[] args) {
        So442 so = new So442();
        System.out.println(so.findDuplicates(new int[]{4,2,3,2,3,1,7,8}));
    }
}
