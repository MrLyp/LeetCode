package com.robbie;

import java.util.*;

public class So373 {

    private class NumPair {
        int a;
        int b;
        int sum;

        public NumPair(int a, int b, int sum) {
            this.a = a;
            this.b = b;
            this.sum = sum;
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        PriorityQueue<NumPair> heap = new PriorityQueue<>(new Comparator<NumPair>() {
            @Override
            public int compare(NumPair o1, NumPair o2) {
                return o1.sum - o2.sum;
            }
        });
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                heap.add(new NumPair(nums1[i], nums2[j], nums1[i] + nums2[j]));
            }
        }
        List<List<Integer>> res = new ArrayList<>();
        int length = Math.min(heap.size(), k);
        for (int i = 0; i < length; i++) {
            NumPair first = heap.poll();
            List<Integer> pair = new ArrayList<>(2);
            pair.add(first.a);
            pair.add(first.b);
            res.add(pair);
        }
        return res;
    }

    public static void main(String[] args) {
        So373 so = new So373();
//        System.out.println(so.kSmallestPairs(new int[]{1, 7, 11}, new int[]{2, 4, 6}, 3));
        System.out.println(so.kSmallestPairs(new int[]{1, 1, 2}, new int[]{1, 2, 3}, 3));
    }
}
