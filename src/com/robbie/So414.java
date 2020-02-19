package com.robbie;

import java.util.*;

public class So414 {
    public int thirdMax(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i : nums)
            set.add(i);
        int[] unique = new int[set.size()];
        Iterator<Integer> iter = set.iterator();
        int i = 0;
        while(iter.hasNext()) {
            unique[i++] = iter.next();
        }
        if (unique.length < 3)
            return unique.length == 1 ? unique[0] : Math.max(unique[0], unique[1]);
        return findKth(unique);
    }

    private int findKth(int[] nums) {
        int start = 0;
        int end = nums.length;
        while (start < end) {
            int l = start;
            int h = end - 1;
            int pivot = nums[start];
            while (l <= h) {
                while (l <= h && nums[l] >= pivot)
                    l++;
                while(l <= h && nums[h] < pivot)
                    h--;
                if (l < h) {
                    int temp = nums[h];
                    nums[h] = nums[l];
                    nums[l] = temp;
                    l++;
                    h--;
                }
            }
            int temp = nums[h];
            nums[h] = nums[start];
            nums[start] = temp;
            if (h == 2)
                return nums[h];
            else if (h < 2)
                start = h + 1;
            else
                end = h;
        }
        return nums[start];
    }

    public static void main(String[] args) {
        So414 so = new So414();
        System.out.println(so.thirdMax(new int[]{1,2,4,5}));
    }
}
