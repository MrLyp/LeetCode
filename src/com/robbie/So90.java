package com.robbie;

import java.util.*;

/**
 * Created by leeyunpeng on 2019/7/22.
 */
public class So90 {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        int upper = 1 << nums.length;
        Set<List<Integer>> res = new HashSet<>();
        for (int i = 0; i < upper; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1) {
                    list.add(nums[j]);
                }
            }
            Collections.sort(list);
            res.add(list);
        }
        return new ArrayList<>(res);
    }

    public static void main(String[] args) {
        So90 so = new So90();
        System.out.println(so.subsetsWithDup(new int[]{1, 2, 2}));
    }
}
