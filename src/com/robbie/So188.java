package com.robbie;

import java.util.Arrays;

public class So188 {
    public int maxProfit(int k, int[] prices) {
        if (k < 0 || prices == null || prices.length < 2)
            return 0;
        int length = prices.length;
        // 测试数据故意有k取值很大的情况，导致数组过大
        int maxProfit = 0;
        if (k >= length / 2) {
            for (int i = 1; i < length; i++) {
                int diff = prices[i] - prices[i - 1];
                maxProfit += Math.max(0, diff);
            }
            return maxProfit;
        }
        int[][] g = new int[length][k + 1];
        int[][] l = new int[length][k + 1];
        for (int i = 1; i < length; i++) {
            int diff = prices[i] - prices[i - 1];
            for (int j = 1; j <= k; j++) {
                l[i][j] = Math.max(g[i - 1][j - 1] + Math.max(diff, 0), l[i - 1][j] + diff);
                g[i][j] = Math.max(l[i][j], g[i - 1][j]);
            }
        }
        System.out.println(Arrays.deepToString(l));
        System.out.println(Arrays.deepToString(g));
        return g[length - 1][k];
    }

    public static void main(String[] args) {
        So188 so = new So188();
        System.out.println(so.maxProfit(2, new int[]{3, 2, 6, 5, 0, 3}));
    }
}
