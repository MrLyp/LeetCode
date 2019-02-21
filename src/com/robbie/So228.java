package com.robbie;

import java.util.ArrayList;
import java.util.List;

public class So228 {

    public List<String> summaryRanges(int[] nums) {
        List<String> list = new ArrayList<>();
        int start = 0;
        int index = 0;
        if (nums.length == 1)
            list.add(nums[0] + "");
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - nums[index] == 1) {
                index = i;
            } else {
                if (start == index) {
                    list.add(nums[start] + "");
                } else {
                    list.add(nums[start] + "->" + nums[index]);
                }
                index = start = i;
            }
            if (i == nums.length - 1) {
                if (start == index) {
                    list.add(nums[start] + "");
                } else {
                    list.add(nums[start] + "->" + nums[index]);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        So228 so = new So228();
        System.out.println(so.summaryRanges(new int[]{0,1,2,4,5,7}));
        System.out.println(so.summaryRanges(new int[]{0,2,3,4,6,8,9}));
    }
}
