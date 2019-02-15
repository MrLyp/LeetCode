package com.robbie;

import java.util.HashSet;
import java.util.Set;

public class So217 {

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0 ; i < nums.length; i++) {
            if (set.contains(nums[i]))
                return true;
            set.add(nums[i]);
        }
        return false;
    }

    public static void main(String[] args) {
        So217 so = new So217();
        check(so.containsDuplicate(new int[]{1 ,2, 3, 1}), true);
        check(so.containsDuplicate(new int[]{1 ,2, 3, 4}), false);
        check(so.containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2}), true);
    }

    private static void check(boolean result, boolean expect) {
        if (result == expect) {
            System.out.println("pass");
        } else {
            throw new RuntimeException("expect " + expect);
        }
    }
}
