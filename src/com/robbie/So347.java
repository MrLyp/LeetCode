package com.robbie;


import java.util.*;

public class So347 {


    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int f = map.getOrDefault(nums[i], 0);
            map.put(nums[i], f + 1);
        }
        PriorityQueue<Map.Entry<Integer, Integer>> p = new PriorityQueue<>(
                (Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) -> {
                    return o1.getValue() - o2.getValue();
                }
        );
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            p.add(entry);
            if (p.size() > k)
                p.remove();
        }
        List<Integer> res = new ArrayList<>();
        while (!p.isEmpty())
            res.add(p.remove().getKey());
        return res;
    }


    public static void main(String[] args) {
        So347 so = new So347();
        System.out.println(so.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2));
        System.out.println(so.topKFrequent(new int[]{1, 2}, 2));
    }
}
