package com.robbie;

public class So122 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            int diff = prices[i] - prices[i - 1];
            if (diff > 0)
                max += diff;
        }
        return max;
    }

    public static void main(String[] args) {
        So122 so = new So122();
        System.out.println(so.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}
