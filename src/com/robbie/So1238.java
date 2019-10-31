package com.robbie;

import java.util.*;

public class So1238 {

    public List<Integer> circularPermutation(int n, int start) {
        Set<Integer> result = new HashSet<>();
        List<Integer> list = new ArrayList<>();
        result.add(start);
        list.add(start);
        int length = 1 << n;
        for (int i = 1; i < length ; i++) {
            int last = list.get(i - 1);
            int iter = 1;
            int next = last ^ iter;
            while (result.contains(next)) {
                iter = iter << 1;
                next = last ^ iter;
            }
            result.add(next);
            list.add(next);
//            System.out.println(Integer.toBinaryString(next));
        }
        return list;
    }

    public static void main(String[] args) {
        So1238 so = new So1238();
        System.out.println(so.circularPermutation(2, 3));
        System.out.println(so.circularPermutation(3, 2));
    }
}
