package com.robbie;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

public class So451 {

    class Pair {
        char c;
        int count;

        public Pair(char c, int count) {
            this.c = c;
            this.count = count;
        }
    }

    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()) {
            int count = map.getOrDefault(c, 0);
            map.put(c, count + 1);
        }
        Pair[] ps = new Pair[map.size()];
        int idx = 0;
        for (char c: map.keySet()) {
            ps[idx++] = new Pair(c, map.get(c));
        }
        Arrays.sort(ps, new Comparator<Pair>() {
            @Override
            public int compare(Pair o1, Pair o2) {
                return o2.count - o1.count;
            }
        });
        StringBuilder builder = new StringBuilder();
        for (Pair p : ps) {
            int k = p.count;
            while(k-- > 0)
                builder.append(p.c);
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        So451 so = new So451();
        System.out.println(so.frequencySort("tree"));
        System.out.println(so.frequencySort("cccaaa"));
        System.out.println(so.frequencySort("Aabb"));
    }
}
