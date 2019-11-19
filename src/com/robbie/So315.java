package com.robbie;

import java.util.*;

public class So315 {
    public List<Integer> countSmaller(int[] nums) {
        List<Integer> result = new ArrayList<>();
        if (nums == null || nums.length == 0)
            return result;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], i);
        }
        int[] count = new int[nums.length];
        mergeSort(0, nums.length - 1, nums, map, count);
        for (int value : count) result.add(value);
        return result;
    }

    private void mergeSort(int start, int end, int[] nums, Map<Integer, Integer> map, int[] result) {
        if (start >= end)
            return;
        int mid = start + (end - start) / 2;
        mergeSort(start, mid, nums, map, result);
        mergeSort(mid + 1, end, nums, map, result);
        int i = start;
        int j = mid + 1;
        int t = 0;
        int[] temp = new int[end - start + 1];
        while(i <= mid && j <= end) {
            if (nums[i] > nums[j]) {
                temp[t++] = nums[j++];
            } else {
                result[map.get(nums[i])] += (j - mid - 1);
                temp[t++] = nums[i++];
            }
        }
        while (i <= mid) {
            result[map.get(nums[i])] += (j - mid - 1);
            temp[t++] = nums[i++];
        }
        while (j <= end) {
            temp[t++] = nums[j++];
        }
        for (int k = 0; k < temp.length; k++) {
            nums[k + start] = temp[k];
        }
    }

    public static void main(String[] args) {
        So315 so = new So315();
//        System.out.println(so.countSmaller(new int[]{5, 2, 6, 1}));
//        System.out.println(so.countSmaller(new int[]{2, 0, 1}));
        System.out.println(so.countSmaller(new int[]{26,78,27,100,33,67,90,23,66,5,38,7,35,23,52,22,83,51,98,69,81,32,78,28,94,13,2,97,3,76,99,51,9,21,84,66,65,36,100,41}));
    }
}
