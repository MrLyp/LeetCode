package com.robbie;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class So322 {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(amount);
        int sum = 0;
        HashSet<Integer> path = new HashSet<>();
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int first = queue.poll();
                if (first == 0)
                    return sum;
                for (int i = 0; i < coins.length; i++) {
                    int remain = first - coins[i];
                    if (remain >= 0 && !path.contains(remain)) {
                        queue.add(remain);
                        path.add(remain);
                    }
                }
                size--;
            }
            sum++;
        }
        return -1;
    }

    public static void main(String[] args) {
        So322 so = new So322();
        System.out.println(so.coinChange(new int[]{1,2, 5}, 7));
        System.out.println(so.coinChange(new int[]{186, 419, 83, 408}, 6249));
    }
}
