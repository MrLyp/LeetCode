package com.robbie;

public class So474 {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            String str = strs[i];
            int l0 = 0;
            for (char c : str.toCharArray()) {
                if (c == '0')
                    l0++;
            }
            int l1 = str.length() - l0;
            for (int p = m; p >= l0; p--) {
                for (int q = n; q >= l1; q--) {
                    dp[p][q] = Math.max(dp[p - l0][q - l1] + 1, dp[p][q]);
                }
            }
        }
        return dp[m][n];
    }

    public static void main(String[] args) {
        So474 so = new So474();
        System.out.println(so.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        System.out.println(so.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
    }
}
