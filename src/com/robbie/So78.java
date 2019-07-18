package com.robbie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class So78 {
//    public List<List<Integer>> subsets(int[] nums) {
//        boolean[] track = new boolean[nums.length];
//        List<boolean[]> res = new ArrayList<>();
//        search(track, 0, res);
//        List<List<Integer>> list = new ArrayList<>();
//        for (int i = 0; i < res.size(); i++) {
//            boolean[] temp = res.get(i);
//            List<Integer> ar = new ArrayList<>();
//            for (int j = 0; j < temp.length;j++) {
//                if (temp[j])
//                    ar.add(nums[j]);
//            }
//            list.add(ar);
//        }
//        return list;
//    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        int upper = 1 << nums.length;
        for (int i = 0; i < upper; i++) {
            List<Integer> list = new ArrayList<>();
            for (int j = 0; j < nums.length; j++) {
                if (((i >> j) & 1) == 1)
                    list.add(nums[j]);
            }
            res.add(list);
        }
        return res;
    }


    private void search(boolean[] track, int step, List<boolean[]> res) {
        if (step == track.length) {
            boolean[] temp = new boolean[track.length];
            System.arraycopy(track, 0, temp, 0, track.length);
            res.add(temp);
            return;
        }
        for (int i = 0; i < 2; i++) {
            boolean t = track[step];
            track[step] = (i == 0);
            search(track, step + 1, res);
            track[step] = t;
        }
    }

    public static void main(String[] args) {
        So78 so = new So78();
        System.out.println(so.subsets(new int[]{1, 2, 3}));
    }
}
