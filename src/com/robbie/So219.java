package com.robbie;

import java.util.*;

public class So219 {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(map.get(nums[i]) - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    public static void main(String[] args) {
        So219 so = new So219();
        check(so.containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3), true);
        check(so.containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1), true);
        check(so.containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2), false);
    }

    private static void check(boolean result, boolean expect) {
        if (result == expect) {
            System.out.println("pass");
        } else {
            throw new RuntimeException("expect " + expect);
        }
    }
}
