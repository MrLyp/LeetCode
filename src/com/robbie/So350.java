package com.robbie;

import java.util.*;

public class So350 {
    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int item : nums1) {
            map1.put(item, map1.getOrDefault(item, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int item : nums2) {
            if (map1.getOrDefault(item, 0) > 0) {
                res.add(item);
                map1.put(item, map1.get(item) - 1);
            }
        }

        int[] intersection = new int[res.size()];
        int index = 0;
        for (int item : res) {
            intersection[index++] = item;
        }
        return intersection;
    }

    public static void main(String[] args) {
        So350 so = new So350();
        System.out.println(Arrays.toString(so.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(so.intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
