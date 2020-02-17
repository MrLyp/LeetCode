package com.robbie;

import java.util.*;

public class So398 {
    static class Solution {

        private Map<Integer, List<Integer>> map = new HashMap<>();

        private Random random = new Random();

        public Solution(int[] nums) {
            for (int i = 0; i < nums.length; i++) {
                List<Integer> list = map.get(nums[i]);
                if (list == null) {
                    list = new ArrayList<>();
                }
                list.add(i);
                map.put(nums[i], list);
            }
        }

        public int pick(int target) {
            List<Integer> list = map.get(target);
            return list.get(random.nextInt(list.size()));
        }
    }

    public static void main(String[] args) {
        Solution so = new Solution(new int[]{1,2,3,3,3});
        System.out.println(so.pick(3));
        System.out.println(so.pick(3));
        System.out.println(so.pick(3));
        System.out.println(so.pick(1));
    }
}
