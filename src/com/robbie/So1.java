package com.robbie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class So1 {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] result = new int[2];
        for (int i = 0; i < nums.length; i++) {
            int index = map.get(target - nums[i]);
            if (index > 0 && index != i) {
                result[0] = i;
                result[1] = index;
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        // write your code here
        So1 so = new So1();
        System.out.println(Arrays.toString(so.twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(so.twoSum(new int[]{3, 2, 4}, 6)));
    }
}
