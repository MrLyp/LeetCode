package com.robbie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class So491 {
    public List<List<Integer>> findSubsequences(int[] nums) {
        Set<List<Integer>> res = new HashSet<>();
        doFind(res, new ArrayList<>(), 0, nums);
        return new ArrayList<>(res);
    }

    private void doFind(Set<List<Integer>> res, List<Integer> cur, int index, int[] num) {
        if (cur.size() > 1) {
            res.add(new ArrayList<>(cur));
        }
        for (int i = index; i < num.length; i++) {
            if (cur.isEmpty() || cur.get(cur.size() - 1) <= num[i]) {
                Integer item = num[i];
                cur.add(item);
                doFind(res, cur, i + 1, num);
                cur.remove(item);
            }
        }
    }

    public static void main(String[] args) {
        So491 so = new So491();
        System.out.println(so.findSubsequences(new int[]{4, 6, 7, 7}));
    }
}
