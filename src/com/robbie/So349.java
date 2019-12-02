package com.robbie;

import java.util.*;

public class So349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        if (nums1 == null || nums2 == null)
            return null;
        Set<Integer> set1 = new HashSet<Integer>();
        Set<Integer> res = new HashSet<Integer>();
        for (int item : nums1)
            set1.add(item);
        for (int item : nums2) {
            if (set1.contains(item))
                res.add(item);
        }

        if (res.isEmpty())
            return new int[0];
        int[] intersection = new int[res.size()];
        int index = 0;
        for (int item : res) {
            intersection[index++] = item;
        }
        return intersection;
    }

    public static void main(String[] args) {
        So349 so = new So349();
        System.out.println(Arrays.toString(so.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2})));
        System.out.println(Arrays.toString(so.intersection(new int[]{4,9,5}, new int[]{9,4,9,8,4})));
    }
}
