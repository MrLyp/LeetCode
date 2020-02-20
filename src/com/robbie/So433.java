package com.robbie;

import java.util.HashMap;
import java.util.Map;

public class So433 {
    int min = Integer.MAX_VALUE;
    public int minMutation(String start, String end, String[] bank) {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < bank.length; i++){
            String cur = bank[i];
            if (canMutate(start, cur)) {
                bank[i] = null;
                int dist = search(cur, end, bank.clone(), 1);
                if (dist > 0) {
                    min = Math.min(min, dist);
                }
                bank[i] = cur;
            }
        }
        if (min == Integer.MAX_VALUE)
            return -1;
        return min;
    }

    private int search(String start, String end, String[] bank, int step) {
        if (step >= min)
            return -1;
        if (start.equals(end))
            return step;
        for (int i = 0; i < bank.length; i++) {
            if (bank[i] == null)
                continue;
            String cur = bank[i];
            if (canMutate(start, cur)) {
                bank[i] = null;
                int dis = search(cur, end, bank, step + 1);
                if (dis > 0)
                    return dis;
                bank[i] = cur;
            }
        }
        return -1;
    }

    private boolean canMutate(String start, String end) {
        int count = 0;
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != end.charAt(i))
                count++;
            if (count > 1)
                return false;
        }
        return count == 1;
    }

    public static void main(String[] args) {
        So433 so = new So433();
        System.out.println(so.minMutation("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA", "AACCGCTA", "AAACGGTA"}));
        System.out.println(so.minMutation("AAAAACCC", "AACCCCCC", new String[]{"AAAACCCC", "AAACCCCC", "AACCCCCC"}));
    }
}
