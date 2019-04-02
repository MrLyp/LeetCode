package com.robbie;

public class So309 {

    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 0)
            return 0;
        int[] buy = new int[n];
        buy[0] = -prices[0];
        int[] sell = new int[n];
        for (int i = 1; i < n;i++) {
            if (i > 1) {
                buy[i] = Math.max(buy[i - 1], sell[i - 2] - prices[i]);
            } else {
                buy[i] = Math.max(buy[i - 1], - prices[i]);
            }
            sell[i] = Math.max(sell[i-1], buy[i-1] + prices[i]);
        }
        return sell[n - 1];
    }

    public static void main(String[] args) {
        So309 so = new So309();
        check(so.maxProfit(new int[]{1,2,3,0,2}), 3);
    }

    private static void check(int n, int expect) {
        if (n != expect) {
            throw new RuntimeException(n + " failed, expected " + expect);
        } else {
            System.out.println(n + " passed");
        }
    }
}
