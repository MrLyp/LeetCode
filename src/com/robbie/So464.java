package com.robbie;

public class So464 {
    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        if (desiredTotal <= 0) return true;
        if (maxChoosableInteger * (maxChoosableInteger + 1) / 2 < desiredTotal) return false;
        int[] dp = new int[1 << maxChoosableInteger];
        return dfs(0, maxChoosableInteger, desiredTotal, dp);
    }

    private boolean dfs(int mask, int max, int target, int[] dp) {
        if (target <= 0)
            return false;
        if (dp[mask] != 0)
            return dp[mask] == 1;
        boolean res = false;
        for (int i = 0; i < max; i++) {
            if ((mask & (1 << i)) != 0)
                continue;
            res = res || !dfs(mask ^ (1 << i), max, target - i - 1, dp);
        }
        dp[mask] = res ? 1 : -1;
        return res;
    }

    public static void main(String[] args) {
        So464 so = new So464();
        System.out.println(so.canIWin(10, 11));
    }
}
