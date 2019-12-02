package com.robbie;

public class So357 {
    public int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        if (n == 1)
            return 10;
        if (n == 2)
            return 91;
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 10;
        dp[2] = 81;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] * (10 - i + 1);
        }
        int sum = 0;
        for (int item : dp)
            sum += item;
        return sum;
    }

    public static void main(String[] args) {
        So357 so = new So357();
        System.out.println(so.countNumbersWithUniqueDigits(2));
    }
}
